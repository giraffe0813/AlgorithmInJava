package com.ymy.algorithms.statistics;

/**
 * 一段长n米的绳子(n>=2) 至少切一刀 将绳子分成多段使得多段的乘积最大
 * eg:
 * 绳长: 4
 * 可能的分割: (1*1*1*1, 2*1*1, 3*1, 2*2)
 * 最大的乘积: 2*2 = 4
 * 解法来自: http://algorithms.tutorialhorizon.com/dynamic-programming-maximum-product-cutting-problem/
 * Created by yemengying on 16/4/11.
 */
public class MaxmumProductCutting {

    /**
     * 求将n米绳子分割后最大的乘积
     * 利用动态规划
     * maxProduct[i] = n if n=1 || n=0
     * maxProduct[i] = Max{j*(i-j),select[i-j]*j} 0<j<i
     * @param n
     * @return
     */
    public static int maxmumProduct(int n){
        //maxProduct[i]的值为切分i米的绳子乘积最大值是多少
        int[] maxProduct = new int[n+1];
        //每次循环需要重置 每次循环之后select的最大值就只maxProduct[i]的值
        int[] select = new int[n];
        maxProduct[0] = 0;
        maxProduct[1] = 1;
        for(int i=2; i<n+1; i++){
            for(int j=1;j<n;j++){
                select[j] = -1;
            }
            for(int j=1;j<i;j++){
                select[j] = Math.max(j * (i-j), maxProduct[i-j] * j);
            }
            for(int j=1;j<i;j++){
                if(select[j] > maxProduct[i]) maxProduct[i] = select[j];
            }
        }

        return maxProduct[n];
    }
}
