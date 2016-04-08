package algorithms.statistics;

import algorithms.Util;
import com.ymy.algorithms.sort.InsertionSort;
import com.ymy.algorithms.sort.MergeSort;
import com.ymy.algorithms.sort.QuickSort;
import com.ymy.algorithms.sort.RandomQuickSort;
import com.ymy.algorithms.statistics.*;
import com.ymy.algorithms.string.LPS1;
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
        int[] arr = {1,3,5,2,4};
        int k = 2;
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


    /**
     * 计算给定数组的最长递增子序列
     */
    @Test
    public void getLengthOfLIS(){
        logger.info("解法1:求数组最长连续递增子序列的长度");
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        int length = LIS.lengthOfLIS(nums);
        logger.info("长度为:{}", length);

        logger.info("解法2:求数组最长连续递增子序列的长度");
        length = LIS.lengthOfLIS2(nums);
        logger.info("长度为:{}", length);
    }

    @Test
    public void maxSubarraySumTest(){
        logger.info("获取指定数组连续子数组的和最大值:");
        int[] nums = new int[]{10,9,2,5,3,-2,101,18};
        logger.info("最大和为:{}", MaxSubarraySum.getMaxSubArraySum(nums));
    }



}
