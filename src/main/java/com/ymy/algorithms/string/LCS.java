package com.ymy.algorithms.string;

/**
 * 求两个字符串的最长公共子序列(是子序列 不是子串,子序列可以不连续)
 * 假设两个字符串的长度为m,n 算法时间复杂度为O(m*n)
 * Created by yemengying on 16/4/4.
 */
public class LCS {


    private static Integer[][] matrix; //matrix[i][j] 表示x[0...i-1],y[0..j-1]的最长公共子序列的长度;
    private static Integer[][] flag; //回溯时使用 记录matrix[i][j]是通过matrix[i-1][j-1]加1得到 还是比较Max(matrix[i][j-1],matrix[i-1][j])得到
                                    //0代表matrix[i-1][j-1]加1,1代表matrix[i][j-1],-1代表matrix[i-1][j]

    public static int getLCSLength(String x, String y){
        matrix = new Integer[x.length() +1 ][y.length() + 1]; //根据字符串长度构建数组
        flag = new Integer[x.length() +1 ][y.length() + 1]; //根据字符串长度构建数组
        for(int index1=0;index1<=x.length();index1++){//作为递归的终止条件
            matrix[index1][0] = 0;
        }
        for(int index2=0;index2<=y.length();index2++){
            matrix[0][index2] = 0;
        }

        return getLCSLengthHelper(x,y,x.length(),y.length());

    }

    /**
     * 获得x[0...i-1],y[0...j-1]的最长公共子序列的长度
     * LCS的递归公式
     *
     * @param x 字符串1
     * @param y 字符串2
     * @param i
     * @param j
     * @return
     */
    public static int getLCSLengthHelper(String x, String y, int i,int j){
        //omitted handle exception
        if(matrix[i][j] == null){
            if(x.charAt(i-1) == y.charAt(j-1)) {
                matrix[i][j] = getLCSLengthHelper(x, y, i - 1, j - 1) + 1;
                flag[i][j] = 0;
            }
            else{
                int up = getLCSLengthHelper(x,y,i-1,j);
                int left = getLCSLengthHelper(x,y,i,j-1);
                if(up > left){
                    matrix[i][j] = matrix[i-1][j];
                    flag[i][j] = 1;
                }else{
                    matrix[i][j] = matrix[i][j-1];
                    flag[i][j] = -1;
                }
            }
        }

        return matrix[i][j];
    }

    /**
     * 根据构建好的通过回溯法构建x[0..i-1]和y[0..j-1]的最长公共序列
     * @param i
     * @param j
     */
    public static void reconstruct(int i,int j){
        if(i==0||j==0) return;
        if(flag[i][j]==0){
            System.out.println(String.format("最长公共子序列坐标,x中位置%d,y中位置%d", i - 1, j-1));
            reconstruct(i-1,j-1);
        }else{
            if(flag[i][j]==-1) {
                reconstruct(i, j - 1);
            }else{
                reconstruct(i-1,j);
            }
        }
    }

}
