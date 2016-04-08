package com.ymy.algorithms.string;

/**
 * 最长回文子序列
 * Created by yemengying on 16/4/7.
 */
public class LPS1 {

    /**
     * lps[i][j]代表字符串索引i到索引j之间回文子序列的长度
     * lps的递归公式:
     * lps[i][j] = 1 if i=j
     * lps[i][j] = 2 + lps[i+1][j-1] if str[i] = str[j]
     * lps[i][j] = Max{lps[i+1][j] ,lps[i][j-1] } if str[i]!=str[j]
     * lps[i][j] = 0 otherwise
     */
    private static int[][] lps;

    /**
     * 用于回溯
     * flag[i][j] = 1 代表 lps[i][j] = 2 + lps[i+1][j-1]
     * flag[i][j] = 2 代表 lps[i][j] = lps[i+1][j];
     * flag[i][j] = 3 代表 lps[i][j] = lps[i][j-1];
     * flag[i][j] = 4 代表 i=j
     */
    private static int[][] flag;

    public static int getLengthOfLps(String s){
        if(s == null || "".equals(s)) return 0;
        //初始化lps
        lps = new int[s.length()][s.length()];
        flag = new int[s.length()][s.length()];
        return getLengthOfLpsHelper(s, 0, s.length()-1);
    }

    public static int  getLengthOfLpsHelper(String s,int i, int j){
        if(i == j) {
            lps[i][j] = 1;
            flag[i][j] = 4;
        }
        if(lps[i][j] == 0){
            if(s.charAt(i) == s.charAt(j)){
                lps[i][j] = 2 +getLengthOfLpsHelper(s,i+1,j-1);
                flag[i][j] = 1;

            }else{
                int m = getLengthOfLpsHelper(s,i+1,j);
                int n = getLengthOfLpsHelper(s,i,j-1);
                lps[i][j] = Math.max(m,n);
                flag[i][j] = (m>n) ? 2:3;
            }
        }
        return lps[i][j];
    }


    /**
     * 根据flag数组回溯出最长回文子序列
     * @param s
     * @param i
     * @param j
     */
    public static void printLps(String s,int i,int j){
        switch (flag[i][j]){
            case 1:
                //注意打印的顺序
                System.out.println(String.format("回文子序列,位置:%s,字母:%s", i, s.charAt(i)));
                printLps(s,i+1,j-1);
                System.out.println(String.format("回文子序列,位置:%s,字母:%s", j, s.charAt(j)));
                break;
            case 2:
                printLps(s,i+1,j);
                break;
            case 3:
                printLps(s,i,j-1);
                break;
            case 4:
                System.out.println(String.format("回文子序列,位置:%s,字母:%s", i, s.charAt(i)));
                break;
        }

    }
}
