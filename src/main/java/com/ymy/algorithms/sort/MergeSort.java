package com.ymy.algorithms.sort;

/**
 * 归并排序 从小到大
 * 复杂度为O(n*lgn)
 * Created by yemengying on 16/4/3.
 */
public class MergeSort {

    public static void mergeSort(int[] arr){
        mergeSortHelper(arr, 0, arr.length-1);
    }

    public static void  mergeSortHelper(int[] arr, int begin, int end){
        int mid = (begin+end)/2;
        if(begin < end){
            mergeSortHelper(arr, begin, mid);
            mergeSortHelper(arr, mid + 1, end);
            merge(arr, begin, mid ,end);
        }

    }

    /**
     * low~mid代表左子数组
     * mid+1~high代表右子数组
     * @param arr
     * @param low
     * @param mid
     * @param high
     */
    public static void merge(int[] arr, int low, int mid ,int high){
        int[] result = new int[high - low +1];//构造最后合并出的数组
        int i=low;
        int j=mid+1;
        int index = 0;
        while(i <= mid && j <= high){
            if(arr[i] < arr[j]){
                result[index++] = arr[i++];
            }else{
                result[index++] = arr[j++];
            }
        }
        while(i <= mid){
            result[index++] = arr[i++];
        }
        while(j <=high){
            result[index++] = arr[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (index = 0; index < result.length; index++) {
            arr[index + low] = result[index];
        }
    }

}
