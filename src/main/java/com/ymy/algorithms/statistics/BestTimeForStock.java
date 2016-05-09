package com.ymy.algorithms.statistics;

/**
 * 给定一个数组 包含每天股票的价格 求在允许一次交易的前提下最大利润是什么
 * Created by yemengying on 16/4/27.
 */
public class BestTimeForStock {

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
        int profit = 0;
        int currentMinPrice = prices[0];
        for(int i = 0; i< prices.length;i++){
            currentMinPrice = Math.min(currentMinPrice, prices[i]);
            profit = Math.max(profit, prices[i] - currentMinPrice);
        }

        return profit;
    }
}
