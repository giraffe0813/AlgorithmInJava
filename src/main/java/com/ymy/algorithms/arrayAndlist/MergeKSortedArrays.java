package com.ymy.algorithms.arrayAndlist;

import com.ymy.algorithms.model.HeapNode;

/**
 * 将k个以排好序的数组按顺序合并成一个
 * eg:
 * int[][] A = new int[5][];
 * A[0] = new int[] { 1, 5, 8, 9 };
 * A[1] = new int[] { 2, 3, 7, 10 };
 * A[2] = new int[] { 4, 6, 11, 15 };
 * A[3] = new int[] { 9, 14, 16, 19 };
 * A[4] = new int[] { 2, 4, 6, 9 };
 * Output:
 * [1, 2, 2, 3, 4, 4, 5, 6, 6, 7, 8, 9, 9, 9, 10, 11, 14, 15, 16, 19]
 *
 * 解法参考:http://algorithms.tutorialhorizon.com/merge-k-sorted-arrays/
 *
 * 解法1:
 * 假设有k个数组,总共元素个数为n 将所有元素复制到一个数组中,然后再进行归并排序 时间复杂度为O(n) + O(nlgn)
 * 解法2:
 * 利用最小二叉堆,复杂度为(nlgk)
 * 下面实现第二种解法
 *
 * Created by yemengying on 16/4/12.
 */
public class MergeKSortedArrays {

    private HeapNode[] minHeap;
    private int[] result;
    private int position = 1;
    public int[] merge(int[][] a) {

        // 数组的个数
        int arrNums = a.length;
        if(arrNums == 0) return new int[0];
        //总共的元素数
        int total = arrNums * a[0].length;
        //初始化result
        result = new int[total];
        //初始化最小堆
        minHeap = new HeapNode[a.length + 1];
        //索引从1开始 0无意义
        minHeap[0] = new HeapNode(0,-1);
        //记录每个数组应该访问的位置
        int[] ptrs = new int[a.length];
        //依次每个数组的第一个元素插入到堆中
        for(int i = 0; i< a.length;i++){
            insertHeap(a[i][0],i);
        }
        int count = 0;
        while(count < total){
            HeapNode heapNode = extractMin();
            result[count] = heapNode.getData();
            int listNumber = heapNode.getList();
            ptrs[listNumber]++;
            if(ptrs[listNumber] < a[0].length){
                insertHeap(a[listNumber][ptrs[listNumber]], listNumber);
            }else{
                insertHeap(Integer.MAX_VALUE, listNumber);
            }
            count++;
        }

        return  result;
    }

    private void insertHeap(int data,int list){
        HeapNode h = new HeapNode(data,list);
        minHeap[position] = h;
        bubbleUp(position);
        position++;
    }

    private void bubbleUp(int position){
        int pos = position;
        while(pos/2 >= 1 && minHeap[pos/2].getData() > minHeap[pos].getData()){
            swap(pos,pos/2);
            pos = pos/2;
        }
    }

    private void swap(int i,int j){
        HeapNode temp = minHeap[i];
        minHeap[i] = minHeap[j];
        minHeap[j] = temp;
    }


    private HeapNode extractMin(){
        HeapNode heap = minHeap[1];
        minHeap[1] = minHeap[--position];
        sinkDown(1);
        return heap;
    }


    private void sinkDown(int k){
        int smallest = k;
        if(2*k < position && minHeap[2*k].getData() < minHeap[k].getData()){
            smallest = 2*k;
        }
        if(2*k+1 < position && minHeap[2*k + 1].getData() < minHeap[smallest].getData()){
            smallest = 2 *k+1;
        }
        if(smallest != k){
            swap(k,smallest);
            sinkDown(smallest);
        }

    }
}
