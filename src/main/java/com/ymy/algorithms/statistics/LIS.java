package com.ymy.algorithms.statistics;

import com.ymy.algorithms.sort.QuickSort;

/**
 * 获得数组中最长自增子序列的长度
 * eg:[10,9,2,5,3,7,101,18] 最长自增子序列之一是[2,3,7,101],所以返回4
 * leetcode第300题
 * Created by yemengying on 16/4/5.
 */
public class LIS {

    private static Integer[][] matrix; //matrix[i][j] 表示x[0...i-1],y[0..j-1]的最长公共子序列的长度;

    /**
     * 解法1: 利用快排和LCS(最长公共子序列)
     * eg:输入[2,3,4,1]
     * 先利用快排得到排序后的数组[1,2,3,4]
     * 再求两个数组的最长公共子序列的长度,即为[2,3,4]的长度, 也就是最长递增子序列的长度
     * 时间复杂度=快排的复杂度+求最长公共子序列的复杂度 = O(nlgn) + O(n*n) = O(n^2)(数组长度为n)
     * 这种方法不是很好 会耗费大量额外的空间 比如:当输入数组长度为2500时 要构造个2500*2500的二维数组
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        if(nums == null) return 0;
        if(nums.length <= 1) return nums.length;
        int[] sortedArr = nums.clone();
        QuickSort.quickSort(sortedArr);
        matrix= new Integer[nums.length + 1][nums.length +1 ];//用一个数组记录计算过的子序列长度 避免重复计算
        for(int i=0;i<nums.length;i++){
            matrix[i][0] = 0;
            matrix[0][i] = 0;
        }
        return getLCSLengthOfArr(nums, sortedArr, nums.length, sortedArr.length);
    }

    /**
     * 获得数组firstArr[0...firstlen-1],secondArr[0...secondlen-1]的最长公共子序列长度
     * @param
     * @return
     */
    private static int getLCSLengthOfArr(int[] firstArr, int[] secondArr, int firstLen, int secondLen){

        if(matrix[firstLen][secondLen] == null) {
            if (firstArr[firstLen-1] == secondArr[secondLen-1]) {
                matrix[firstLen][secondLen] = getLCSLengthOfArr(firstArr, secondArr, firstLen-1, secondLen-1) + 1;
            }else{
                int up = getLCSLengthOfArr(firstArr, secondArr, firstLen -1 ,secondLen);
                int left = getLCSLengthOfArr(firstArr, secondArr, firstLen , secondLen -1 );
                matrix[firstLen][secondLen] = Math.max(up,left);

            }
        }
        return matrix[firstLen][secondLen];
    }

    /**
     * lcs[i]对应的是以nums[i]为最后一个元素的递增子序列的长度
     * lcs的递归公式如下:
     * lcs[i] = 1 + Max{lcs[j]} if nums[j] < nums[i] 0<=j<i
     * lcs[i] = 1 if对所有0<=j<i nums[j] > nums[i]
     * eg:[1,2,0,3]
     * lcs[0] = 1
     * lcs[1] = 1 + Max{lcs(1)} = 2
     * lcs[2] = 1
     * lcs[3] = 1 + Max{lcs{1},lcs{2}} = 3
     */
    private static int[] lis;

    /**
     * 解法2: 利用动态规划
     * 代码来自http://algorithms.tutorialhorizon.com/dynamic-programming-longest-increasing-subsequence/
     * 时间复杂度和解法1一样 需要O(n^2) 但是耗费的空间比1小
     * @param nums
     * @return
     */
    public static int lengthOfLIS2(int[] nums){
        if(nums == null) return 0;
        if(nums.length <= 1) return nums.length;
        //初始化数组lis
        lis = new int[nums.length];
        getLIS(nums);
        //返回数组中的最大值 lis数组中的最大值就是最长自增子序列的长度
        int max = Integer.MIN_VALUE;
        int index = 0;
        for(int i=0;i<lis.length;i++){
            if(lis[i] > max) {
                max = lis[i];
                index = i;
            }
        }
        //打印自增序列
        print(nums,index,max);
        return max;

    }

    public static void getLIS(int[] nums){

        for(int i = 0; i<nums.length ; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    lis[i] = (lis[i] < lis[j] + 1) ? lis[j] + 1: lis[i];
                }
            }
            if(lis[i] == 0) lis[i] = 1;
        }

    }


    public static void print(int[] nums ,int index,int max){
        String s = "";
        for(int i = index;i>=0;i--){
            if(lis[i] == max){
                s = nums[i] + " " + s;
                max--;
            }

        }
        System.out.print(s);
    }

}
