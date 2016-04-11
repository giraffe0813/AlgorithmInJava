package com.ymy.algorithms.statistics;

/**
 * 给定一个数字 求平方和等于这个数字的最少数字数目.
 * eg: 12
 * 2^2 + 2^2 + 2^2 = 12
 * 3^2 + 1^2 + 1^2 + 1^2 = 12
 * 所以最少3个数字(2,2,2)
 * 参考: http://algorithms.tutorialhorizon.com/dynamic-programming-minimum-numbers-are-required-whose-square-sum-is-equal-to-a-given-number/
 * Created by yemengying on 16/4/11.
 */
public class SquareNumbers {


    /**
     * 利用动态规划
     * @param nums
     * @return
     */
    public static int getMinNumber(int nums){
        if(nums <= 0) return 0;
        Double sqrt = Math.sqrt(nums);
        //被选择的数字不可能大于upperBound
        int upperBound = sqrt.intValue();
        //sum[i] 代表平方和等于i时需要的最少数字数
        int[] sum= new int[nums + 1];
        //每次循环都需要重置,select[j]代表和为i时,选择j的话需要多少个数字,每次循环之后select的除0外最小值即为sum[i]的值
        int[] select = new int[upperBound + 1];
        for(int i = 1; i<=nums; i++){
            sum[i] = Integer.MAX_VALUE;
            for(int j = 1; j < upperBound +1; j++){
                select[j] = -1;
            }
            for(int j = 1; j < upperBound +1; j++){
                if(j*j <= i) {
                    select[j] = sum[i - j * j] + 1;
                }
            }
            for(int j = 1; j < upperBound +1; j++){
                sum[i] = (sum[i] > select[j] && select[j] != -1) ? select[j] : sum[i];
            }
        }
        return sum[nums];
    }
}
