package com.ymy.algorithms.statistics;

/**
 * 计算给定数字的n次方
 * 利用divide&conquer(分治法)
 * x^n = x^n/2 * x^n/2 (n是偶数)
 * x^n = x^(n-1)/2 * x^(n-1)/2 * x(n是奇数)
 * leetcode 第50题
 * Created by yemengying on 16/3/31.
 */
public class Pow {

    public static double pow(double x , int n){
        if(n == -1) return 1/x; // 因为int的取值是[-2147483648,2147483647] 如果写if(n<0) return pow(x,-n) 当n=-2147483648时会出项stackoverflow的异常
        if(n == 0) return 1;
        if(n == 1) return x;
        double num;
        if(n % 2 == 0) {
            num = pow(x, n/2); //这样可以避免计算两遍 pow(x,n/2)
            return num * num;
        }
        else {
            num = pow(x, (n-1)/2);
            return num * num * x;
        }
    }

}
