package com.ymy.algorithms.arrayAndlist;

import com.ymy.algorithms.model.HeapNode;

/**
 * 将k个排好序的链表合并成一个
 * leetcode 23题
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * Created by yemengying on 16/4/12.
 */
public class MergeKSortedList {


    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

    }

    private ListNode result;
    private HeapNode[] minHeap;
    //记录堆要插入的新元素的位置
    private int position = 1;

    public ListNode merge(ListNode[] lists){
        if(lists == null || lists.length <= 1) return lists[0];
        minHeap = new HeapNode[lists.length+1];
        for(int i = 0;i<lists.length;i++){
            if(lists[i] != null){
                insertHeap(lists[i].val, i);
                lists[i] = lists[i].next;
            }
        }
        ListNode result = null;
        ListNode index = null;
        while(minHeap[1] != null){
            HeapNode heap = extract();
            if(result == null){
                result = new ListNode(heap.getData());
                index = result;
            }else{
                index.next = new ListNode(heap.getData());
                index = index.next;
            }
            if(lists[heap.getList()] != null){
                insertHeap(lists[heap.getList()].val,heap.getList());
                lists[heap.getList()] = lists[heap.getList()].next;
            }
        }

        return result;
    }

    private void insertHeap(int data, int list){
        minHeap[position] = new HeapNode(data,list);
        bubbleUp(position);
        position++;
    }

    private void bubbleUp(int position) {
        int pos = position;
        while (pos/2 >= 1 && minHeap[pos/2].getData() > minHeap[pos].getData()){
            swap(pos,pos/2);
            pos = pos/2;
        }
    }

    private void swap(int i,int j){
        HeapNode temp = minHeap[i];
        minHeap[i] = minHeap[j];
        minHeap[j] = temp;
    }


    private HeapNode extract(){
        HeapNode heap = minHeap[1];
        minHeap[1] = minHeap[position -1];
        minHeap[position -1] = null; //不要忘记
        position--;
        sinkDown(1);
        return heap;
    }

    private void sinkDown(int k) {
        int smallest = k;
        if(2*k < position && minHeap[2*k].getData() < minHeap[k].getData()){
            smallest = 2*k;
        }
        if(2*k+1 < position && minHeap[2*k+1].getData() < minHeap[smallest].getData()){
            smallest = 2*k+1;
        }
        if(smallest != k){
            swap(smallest,k);
            sinkDown(smallest);
        }
    }
}
