package com.ymy.algorithms.sort;

import com.ymy.algorithms.Util;

/**
 * 插入排序 从小到大排序
 * 插入排序的时间复杂度为O(n^2)
 * 最好的情况是输入数组是正序的 需要线性时间即可(O(n))
 * 最坏的情况是输入数组是逆序的 需要O(n^2)
 * Created by yemengying on 16/3/28.
 */
public class InsertionSort {

    public static void insertionSort(int[] arr){
        if(arr != null && arr.length != 0){
            int i,j;
            int key;
            //开始插入排序
            for(i = 1; i < arr.length; i++){
                j = i -1;
                key = arr[i];
                // 将j一直到0的元素依次和key比 如果比key大就后移一位
                while(j >= 0 && arr[j] > key){//一开始错误的把arr[j]>key 写成了arr[j]>arr[i] arr[i]的值一直在变
                    arr[j+1] = arr[j];// 一开始错误的把arr[j+1]=arr[j] 写成了arr[i]=arr[j]
                    j--;
                }
                arr[j+1] = key;
            }

        }
    }

    public static void main(String[] args){
        int[] testarr = {200,32000,522,121,66,131,33,636,88};
        InsertionSort.insertionSort(testarr);
        Util.print(testarr);
    }





}
