package com.ymy.algorithms.statistics;

/**
 * 求给定数组中相邻子数组(至少包含一个值)和的最大值
 * eg:给定[-2,1,-3,4,-1,2,1,-5,4] 和最大的相邻子数组是[4,-1,2,1] 和为6
 * leetcode 53题
 * Created by yemengying on 16/4/7.
 */
public class MaxSubarray {

    private static int[] ms;

    public static int getMaxSubArraySum(int[] nums){
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        //初始化ms数组
        ms = new int[nums.length];
        ms[0] = nums[0];
        for(int i =1; i<nums.length;i++){
             ms[i] = ((nums[i] > nums[i] + ms[i-1]))?nums[i] : ms[i-1]+nums[i];
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<ms.length;i++){
            if(ms[i] > max) max = ms[i];
        }
        return max;

    }
}
