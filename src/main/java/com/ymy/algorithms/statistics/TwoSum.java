package com.ymy.algorithms.statistics;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个数 求数组中和等于这个数的两个数的索引
 * leetcode第一题
 * Created by yemengying on 16/4/17.
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length ==0){
            return new int[]{};
        }
        Integer index1 = null;
        Integer index2 = null;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            index1 = map.get(nums[i]);
            if(index1 == null) {
                map.put(target - nums[i], i);
            }else{
                index2 = i;
                break;
            }

        }
        return new int[]{index1,index2};

    }
}
