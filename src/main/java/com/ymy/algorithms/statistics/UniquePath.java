package com.ymy.algorithms.statistics;

/**
 * 给定一个m*n的数组,求从左上角走到右下角有多少中不同的路径 只能向下和向右走 m和n最大是100
 * leetcode 第62题 https://leetcode.com/problems/unique-paths/
 * Created by yemengying on 16/4/25.
 */
public class UniquePath {

    private Integer[][] dp;

    /**
     * dp[i][j] = Math.max{dp[i-1][j-1] * 2, dp[i-1][j]+dp[i][j] }
     * 利用动态规划
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        // dp[i][j] 代表走一个i+1*j+1的数组有多少种不同的路径
        dp = new Integer[m][n];
        for(int i =0;i<n;i++){
            dp[0][i] = 1;
        }
        for(int i =0;i<m;i++){
            dp[i][0] = 1;
        }
        return getUniquePaths(m,n);
    }

    private int getUniquePaths(int m, int n) {
        if(m == 0 || n == 0) return 0;
        if(dp[m-1][n-1] == null){
            dp[m-1][n-1] = Math.max(getUniquePaths(m-1,n-1)*2, getUniquePaths(m-1,n) + getUniquePaths(m,n-1));
        }
        return dp[m-1][n-1];
    }
}
