package com.ymy.algorithms.statistics;

/**
 * 求第n个斐波那契数字
 * Created by yemengying on 16/4/2.
 */
public class Fibonacci {

    /**
     * 朴素递归解法
     * 该算法的时间复杂度T(n)=Θ(∂^n),其中，∂ = (1 + 5^½) / 2，即黄金分割比率
     * 所以运行时间是指数级的,如果画递归树,也可看出有很多一样的子树,即要做很多重复计算
     * 不建议使用
     * @param n
     * @return
     */
    public static int naiveRecurse(int n){
        //omit handle exception
        if(n == 1 || n == 2) return 1;
        return naiveRecurse(n-1) + naiveRecurse(n-2);
    }

    /**
     * 自底向上解法
     * 计算每一项时只需将前两项相加
     * 所以复杂度为O(n) 花费线性时间
     * @param n
     * @return
     */
    public static int bottomUp(int n){
        int fn = 0;
        int f1 = 1;
        int f2 = 1;
        for(int i=3; i<=n; i++){
            fn = f1 + f2;
            f1 = f2;
            f2 = fn;
        }
        return fn;
    }


}
