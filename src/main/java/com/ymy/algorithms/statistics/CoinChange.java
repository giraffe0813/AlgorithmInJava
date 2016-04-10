package com.ymy.algorithms.statistics;

/**
 * 给定一个数组代表硬币值 从大到小排列 如[1,2,5]
 * 给定一个总数n,求使用最少的硬币数 使得硬币的总和为n , 每种硬币可以重复使用
 * leetcode 322题
 * Created by yemengying on 16/4/10.
 */
public class CoinChange {



    /**
     * 利用动态规划
     * 对于每一个硬币 只有选择和不选择两种状态
     * 如果选择了硬币coins[j]
     * 那么求和为amount的最小硬币数的问题就变成了求和为amount-coins[j]的最小硬币数,因为只要加1 就是和为amount时的答案了
     * @param coins 硬币数组
     * @param amount 总和
     */
    public static int coinChange(int[] coins, int amount){
        if(coins == null || coins.length == 0){
            return -1;
        }
        /**
        * sum[i] 代表达到总数i 需要的最少硬币数
        */
        int[] sum = new int[amount + 1];
        /**
         * 每次循环都要重置一次
         * cc[j] 代表对于当前总数i 如果选择coins[j] 需要的硬币数是多少
         * cc[j]中除了-1之外的最小值 就是sum[i]的值
         */
        int[] cc = new int[coins.length];
        for(int i = 1; i< amount+1;i++){
            sum[i] = -1;
            for(int j=0;j<coins.length;j++){
                cc[j] = -1;
            }
            for(int j = 0;j <coins.length;j++){
                if(coins[j] <= i){
                    cc[j] = (sum[i-coins[j]] == -1)? -1 : sum[i - coins[j]] + 1;
                }
            }
            for(int j=0;j<coins.length;j++){
                if(cc[j] > 0 && (sum[i] == -1 || sum[i] > cc[j])){
                    sum[i] = cc[j];
                }
            }
        }
        return sum[amount];

    }
}
