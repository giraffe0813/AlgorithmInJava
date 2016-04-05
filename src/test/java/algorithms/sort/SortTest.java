package algorithms.sort;

import algorithms.Util;
import com.ymy.algorithms.sort.InsertionSort;
import com.ymy.algorithms.sort.MergeSort;
import com.ymy.algorithms.sort.QuickSort;
import com.ymy.algorithms.sort.RandomQuickSort;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 排序算法测试用例
 * Created by yemengying on 16/3/28.
 */
public class SortTest {

    private static Logger logger = LoggerFactory.getLogger(SortTest.class);

    /**
     * 插入排序测试
     */
    @Test
    public void insertionSortTest(){
        logger.info("插入排序测试");
        int[] testArr = {200,32000,522,121,66,131,33,636,88};
        InsertionSort.insertionSort(testArr);
        Util.print(testArr);
    }


    /**
     * 随机快排测试
     */
    @Test
    public  void randomQuickSortTest(){
        logger.info("随机化快速排序测试");
        int[] testArr = {1,2,3,4,5,6,7,8};
        RandomQuickSort.randomQuickSort(testArr);
        Util.print(testArr);
    }


    /**
     * 快速排序测试
     */
    @Test
    public void quickSortTest(){
        logger.info("快速排序测试");
        int[] testArr = {200,32000,522,121,66,131,33,636,88};
        QuickSort.quickSort(testArr);
        Util.print(testArr);
    }


    /**
     * 合并排序
     */
    @Test
    public void mergeSortTest(){
        logger.info("归并排序测试");
        int[] testArr = {200,32000,522,121,66,131,33,636,88};
        MergeSort.mergeSort(testArr);
        Util.print(testArr);
    }







}
