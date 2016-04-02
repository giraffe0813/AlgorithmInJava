package com.ymy.algorithms.sort;

import com.ymy.algorithms.Util;

/**
 * 快速排序
 * 时间复杂度为O(n*lgn)
 * 最坏的情况是输入的数组是正序或者逆序 时间复杂度为O(n^2)
 * Created by yemengying on 16/3/29.
 */
public class QuickSort {

    public static void quickSort(int[] arr){
        //omitted handle exception
        quickSortHelper(arr, 0, arr.length - 1);
    }

    private static void quickSortHelper(int[] arr, int begin, int end){
        if(begin < end){
            int position = partition(arr, begin ,end);
            quickSortHelper(arr, begin, position-1);
            quickSortHelper(arr, position+1, end);
        }

    }

    //对指定数组进行划分 固定选取第一个元素作为pivot 将数组分为 <=pivot|pivot|>=pivot三部分 并返回pivot的位置
    private static int partition(int[] arr, int begin, int end){
        int i = begin;
        int pivot = arr[i];
        for(int j = i+1; j <= end; j++){
            if(arr[j] < pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,begin,i); //一开始错误的把begin写死成了0
        return i;
    }

    /**
     * 将数组i,j位置的数字交换
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j){
        int temp;
        temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void main(String[] args){
        int[] testarr = {200,32000,522,121,66,131,33,636,88};
        QuickSort.quickSort(testarr);
        Util.print(testarr);
    }


}
