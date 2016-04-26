package com.ymy.algorithms.statistics;

/**
 * 在UniquePath的基础上增加了障碍,用0和1 表示可走和障碍
 * leetcode 63 题 https://leetcode.com/problems/unique-paths-ii/
 * Created by yemengying on 16/4/26.
 */
public class UniquePath2 {

    private Integer[][] dp;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length < 1) return 0;
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        dp = new Integer[row][column];
        int value = 1;
        //初始化
        for(int i =0;i<column;i++){
            if(obstacleGrid[0][i] == 1){
                value = 0;
            }
            dp[0][i] = value;
        }
        value = 1;
        for(int i =0;i<row;i++){
            if(obstacleGrid[i][0] == 1){
                value = 0;
            }
            dp[i][0] = value;
        }
        return getPath(obstacleGrid,row,column);

    }

    private int getPath(int[][] obstacleGrid,int m, int n) {
        if(obstacleGrid[m-1][n-1] == 1) return 0;
        if(dp[m-1][n-1] == null){
            dp[m-1][n-1] = Math.max(getPath(obstacleGrid,m-1,n-1)*2, getPath(obstacleGrid,m-1,n) + getPath(obstacleGrid,m,n-1));
        }
        return dp[m-1][n-1];
    }

}
