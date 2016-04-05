package algorithms.statistics;

import algorithms.Util;
import com.ymy.algorithms.sort.InsertionSort;
import com.ymy.algorithms.sort.MergeSort;
import com.ymy.algorithms.sort.QuickSort;
import com.ymy.algorithms.sort.RandomQuickSort;
import com.ymy.algorithms.statistics.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 跟统计有关的算法测试用例
 * Created by yemengying on 16/3/28.
 */
public class StatisticsTest {

    private static Logger logger = LoggerFactory.getLogger(StatisticsTest.class);

    /**
     * 计算给定数字的n次方
     */
    @Test
    public void powTest(){
        logger.info("测试求x的n次方");
        double x = 1.0000;
        int n = -2147483648;
        logger.info("测试结果:{}", Pow.pow(x,n));

    }


    /**
     * 最小的第k个数字测试
     */
    @Test
    public void kthTest() throws Exception {
        logger.info("求最小的第k个数字测试");
        int[] arr = {1};
        int k = 1;
        int target = GetKthNumber.getKthNumber(arr,k);
        logger.info("第{}个数字为:{} ", k, target);
    }

    /**
     * 求第n个斐波那契数字
     */
    @Test
    public void fibonacciTest(){
        logger.info("斐波那契数字测试");
        long startTime = System.currentTimeMillis();
        logger.info("朴素递归结果:{}" ,Fibonacci.naiveRecurse(45));
        logger.info("朴素递归用时:{}毫秒", System.currentTimeMillis()-startTime);
        startTime = System.currentTimeMillis();
        logger.info("自底向上结果:{}" ,Fibonacci.bottomUp(45));
        logger.info("自底向上用时:{}毫秒", (System.currentTimeMillis()-startTime));
    }

}