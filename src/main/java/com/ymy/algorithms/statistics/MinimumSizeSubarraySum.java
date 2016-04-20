package com.ymy.algorithms.statistics;

/**
 * leetcode第209题
 * 给定一个数组(都是正整数)和一个正整数s,判断数组中和大于s的长度最短的连续子数组
 * Created by yemengying on 16/4/18.
 */
public class MinimumSizeSubarraySum {

    /**
     * 算法复杂度O(n)
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        if(nums==null || nums.length<1)
            return 0;

        int start=0, end=0, sum=0, min=Integer.MAX_VALUE;

        while(end<nums.length){
            sum+=nums[end];

            //optimize the array
            while(sum>=s){
                min=Math.min(min, end-start+1);
                sum-=nums[start++];
            }
            end++;
        }
        return min== Integer.MAX_VALUE ? 0 : min;
    }
}
