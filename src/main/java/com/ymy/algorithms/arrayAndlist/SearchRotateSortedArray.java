package com.ymy.algorithms.arrayAndlist;

/**
 * leetcode第33题 https://leetcode.com/problems/search-in-rotated-sorted-array/
 * 解法参考:http://algorithms.tutorialhorizon.com/search-an-element-in-a-rotated-sorted-array/
 * eg: 给定数组[4,5,6,7,0,1,2,3] 查找 3
 * 解法一:
 * 遍历 时间复杂度是O(n)
 * 解法二:
 * 利用二分查找 时间复杂度是O(lgn)
 * 下面实现第二种解法
 * Created by yemengying on 16/4/12.
 */
public class SearchRotateSortedArray {

    public int search(int[] nums, int target){
        if(nums == null || nums.length < 1) return -1;
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = (low + high)/2;
            if (target == nums[mid]) return mid;
            //说明arr[low..mid]之间是递增的
            if (nums[mid] >= nums[low]) {
                if ( nums[low]<= target && target < nums[mid]) {
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
            //说明arr[mid..high]之间是递增的
            else{
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid +1;
                }else{
                    high = mid - 1;
                }
            }
        }

        return -1;
    }


}
