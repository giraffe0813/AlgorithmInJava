package com.ymy.algorithms.statistics;

import java.util.Random;

/**
 * 获得乱序数组中第K小的数字
 * 无需将数组完全排好序
 * 利用快排中的划分思想
 * 时间复杂度近似为O(n)
 * leetcode 第215题的变形
 * Created by yemengying on 16/3/30.
 */
public class GetKthNumber {

    public static int getKthNumber(int[] arr, int k) throws Exception {

        return getKthNumberHelper(arr, 0, arr.length - 1, k);

    }


    /**
     * 获取数组指定范围中排在第k位的数字
     * @param arr
     * @param k
     * @return
     */
    public static int getKthNumberHelper(int[] arr,int begin,int end, int k) throws Exception {
        if(arr == null ||k > arr.length || k < 0){
            throw new Exception("参数不合法");
        }
        if(begin <= end) { //不要忘记递归结束条件 与快排不一致 多了一个等于的情况
            int position = partition(arr, begin, end);
            int rank = position - begin + 1;//该元素在指定范围的数组中前面有多少个元素(包括自己)
            if (rank == k) {//一开始写错了 拿position与k比较了 要拿在当前子数组的位置与k比较
                return arr[position];
            } else if (rank > k) {
                return getKthNumberHelper(arr, begin, position - 1, k);
            } else {
                return getKthNumberHelper(arr, position + 1, end, k - rank);
            }
        }else{
            throw new Exception("参数不合法");
        }

    }


    /**
     * 划分数组 与快速排序一致
     * @param arr
     * @param begin
     * @param end
     * @return
     */
    public static int partition(int[] arr, int begin, int end){
        int random = new Random().nextInt(end - begin + 1) + begin;
        swap(arr, begin, random);
        int pivot = arr[begin];
        int i = begin;
        for(int j = i+1 ; j <= end; j++){
            if(arr[j] < pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,begin,i);
        return i;
    }

    public static void swap(int[] arr, int i ,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) throws Exception {

        int[] arr = {1};
        int k = 1;
        int target = getKthNumber(arr,k);
        System.out.println("第"+ k +"个数字为: " + target);

    }
}
