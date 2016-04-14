package com.ymy.algorithms.statistics;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断一个数字是不是快乐数字
 * Created by yemengying on 16/4/14.
 */
public class HappyNumber {

    private List<Integer> list = new ArrayList<>();

    public boolean isHappy(int n) {
        int square = getSqure(n);
        if(square == 1) return true;
        if(list.contains(square)) return false;
        list.add(square);
        return isHappy(getSqure(n));
    }

    public int getSqure(int n){
        if(n < 10) return n*n;
        int square = 0;
        while(n != 0){
            square += (n%10) * (n%10);//不要忘记括号
            n=n/10;
        }
        return square;
    }
}
