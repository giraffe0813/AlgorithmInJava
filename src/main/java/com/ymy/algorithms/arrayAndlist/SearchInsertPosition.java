package com.ymy.algorithms.arrayAndlist;

/**
 * 给定一个数组 和一个数字 如果数字在数组中存在返回所在索引 否则返回应该插入的位置
 * leetcode 第35题 https://leetcode.com/problems/search-insert-position/
 * Created by yemengying on 16/4/19.
 */
public class SearchInsertPosition {

    /**
     * 利用二分查找
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length < 1) return 0;
        int begin = 0;
        int end = nums.length - 1;
        int mid = (begin + end)/2;
        while(begin<end){
            if(nums[mid] == target) return mid;
            if(nums[mid] > target){
                end = mid - 1;
            }else{
                begin = mid + 1;
            }
            mid = (begin + end)/2;
        }
        if(target < nums[mid]){
            return (mid == 0)? 0: mid;
        }else if (target > nums[mid]){
            return mid+1;
        }else{
            return mid;
        }

    }


}
