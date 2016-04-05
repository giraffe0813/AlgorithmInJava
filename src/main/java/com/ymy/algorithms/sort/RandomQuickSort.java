package com.ymy.algorithms.sort;

import java.util.Random;

/**
 * 随机化快速排序
 * 随机选取一个元素与第一个元素交换 之后将第一个元素作为pivot
 * 这样可以防止输入的数组是正序或者逆序时 时间复杂度由o(n*logn)变为o(n^2)
 * Created by yemengying on 16/3/30.
 */
public class RandomQuickSort {


    public static void randomQuickSort(int[] arr){
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

    //对指定数组进行划分 随机选取一个元素与第一个元素交换作为pivot 将数组分为 <=pivot|pivot|>=pivot三部分 并返回pivot的位置
    private static int partition(int[] arr, int begin, int end){
        // nextInt(x) 返回[0,x)间的一个随机数
        int random = new Random().nextInt(end - begin + 1) + begin;
        swap(arr, begin , random);
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

}
