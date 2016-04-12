package com.ymy.algorithms.model;

/**
 * Created by yemengying on 16/4/12.
 */
public class HeapNode {
    private int data;
    // 记录该数字属于哪个数组
    private int list;

    public HeapNode(int data, int list) {
        this.data = data;
        this.list = list;
    }

    public int getData() {
        return data;
    }

    public HeapNode setData(int data) {
        this.data = data;
        return this;
    }

    public int getList() {
        return list;
    }

    public HeapNode setList(int list) {
        this.list = list;
        return this;
    }
}
