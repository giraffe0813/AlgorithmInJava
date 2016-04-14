package com.ymy.algorithms.statistics;

/**
 * 给定一个数组 求数组中连续子数组的最大乘积
 * eg:[2,3,-2,4] 最大乘积是6
 * Created by yemengying on 16/4/14.
 */
public class MaximumProductSubarray {


    /**
     * 利用动态规划 要考虑负数的情况
     *
     * @param nums
     * @return
     *
     */
    public int getMaxProduct(int nums[]){
        if(nums == null || nums.length == 0) return 0;
        //maxProduct[i] 代表以nums[i]结尾的 子数组的最大乘积 maxProduct[i] = Max{nums[i],nums[i]*maxProduct[i-1],nums[i]*minProduct[i-1]}
        int[] maxProduct = new int[nums.length];
        //minProduct[i] 代表以nums[i]结尾的 子数组的最小乘积 minProduct[i] = Min{nums[i],nums[i]*minProduct[i-1],nums[i]*maxProduct[i-1]}
        int[] minProduct = new int[nums.length];
        maxProduct[0] = nums[0];
        minProduct[0] = nums[0];
        int max = maxProduct[0];
        for(int i = 1;i < nums.length;i++){
            maxProduct[i] = Math.max(Math.max(nums[i],nums[i]*maxProduct[i-1]),nums[i]*minProduct[i-1]);
            minProduct[i] = Math.min(Math.min(nums[i],nums[i]*minProduct[i-1]),nums[i]*maxProduct[i-1]);
            max = Math.max(maxProduct[i],max);
        }
        return max;

    }
}
