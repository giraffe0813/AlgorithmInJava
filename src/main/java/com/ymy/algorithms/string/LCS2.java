package com.ymy.algorithms.string;

/**
 * 求两个字符串的最长公共子串,
 * 子串要求必须连续
 * eg: ABCB 与 BCD的最长公共子串是BC
 * Created by yemengying on 16/4/9.
 */
public class LCS2 {

    /**
     * 求字符串x与y的最长公共子串
     * lcs[i][j]的值为x[0...i-1]与y[0...j-1]的最长公共子串的长度
     * lcs的递归公式
     * lcs[i][j] = 0 if i=0 || j=0
     * lcs[i][j] = lcs[i-1][j-1] + 1 if x[i-1] = y[j-1] && x[i-2] = y[j-2]
     * lcs[i][j] = Max{lcs[i][j-1],lcs[i-1][j]} otherwise
     */
    private static Integer[][] lcs;


    /**
     * 回溯时使用 记录lcs[i][j]是通过哪个递归式得到的
     */
    private static Integer[][] flag;


    public static int getLengthOfLcs(String s1, String s2){
        if("".equals(s1) || "".equals(s2)) return 0;
        lcs = new Integer[s1.length()+1][s2.length()+1];
        flag = new Integer[s1.length()+1][s2.length()+1];
        for(int index1=0;index1<=s1.length();index1++){//作为递归的终止条件
            lcs[index1][0] = 0;
        }
        for(int index2=0;index2<=s2.length();index2++){
            lcs[0][index2] = 0;
        }
        return getLengthOfLcsHelper(s1,s2,s1.length(),s2.length());
    }

    public static int getLengthOfLcsHelper(String s1, String s2, int i, int j){
        if(lcs[i][j] == null){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                if(i == 1 || j == 1 ) {
                    lcs[i][j] = 1;
                    flag[i][j] = 1;
                }else {
                    if (s1.charAt(i - 2) == s2.charAt(j - 2)) {
                        lcs[i][j] = getLengthOfLcsHelper(s1, s2, i - 1, j - 1) + 1;
                        flag[i][j] = 1;
                    } else {
                        int left = getLengthOfLcsHelper(s1, s2, i, j - 1);
                        int up = getLengthOfLcsHelper(s1, s2, i - 1, j);
                        lcs[i][j] = Math.max(left, up);
                        flag[i][j] = (left > up) ? 2 : 3;
                    }
                }
            }else{
                int left = getLengthOfLcsHelper(s1,s2,i,j-1);
                int up = getLengthOfLcsHelper(s1,s2,i-1,j);
                lcs[i][j] = Math.max(left,up);
                flag[i][j] = (left > up) ? 2 :3;
            }
        }
        return lcs[i][j];
    }


    /**
     * 根据构建好的两个数组通过回溯法构建x[0..i-1]和y[0..j-1]的最长公共子串
     * @param i
     * @param j
     */
    public static void reconstruct(int i,int j){
        if(i==0||j==0) return;
        if(flag[i][j]==1){
            System.out.println(String.format("最长公共子串坐标,x中位置%d,y中位置%d", i - 1, j-1));
            reconstruct(i-1,j-1);
        }else{
            if(flag[i][j]==2) {
                reconstruct(i, j - 1);
            }else{
                reconstruct(i-1,j);
            }
        }
    }
}
