package com.ymy.algorithms.statistics;

/**
 * http://algorithms.tutorialhorizon.com/dynamic-programming-rod-cutting-problem/
 * Created by yemengying on 16/4/15.
 */
public class MaxRodPrice {


    /**
     * 利用动态规划
     * @param rod 绳子长度
     * @param values values[i] 为i米绳子的价值
     * @return
     */
    public int bestPrice(int rod,int[] values){
        if(rod <= 0) return 0;
        //dp[i]为切分i+1米绳子可获得的最高价值
        int[] dp = new int[rod];
        dp[0] = values[0];
        for(int i = 1; i<rod; i++){
            int max = values[i];
            for(int j = 0;j<i-1;j++){
                max = Math.max(max, values[j] + dp[i-(j+1)]);
            }
            dp[i] = max;
        }

        return dp[rod-1];
    }
}
