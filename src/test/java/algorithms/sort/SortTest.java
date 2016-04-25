package algorithms.sort;

import algorithms.Util;
import com.sun.deploy.util.StringUtils;
import com.ymy.algorithms.sort.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 排序算法测试用例
 * Created by yemengying on 16/3/28.
 */
public class SortTest {

    private static Logger logger = LoggerFactory.getLogger(SortTest.class);
    int[] testArr = {200,32000,522,121,66,131,33,636,88};

    /**
     * 插入排序测试
     */
    @Test
    public void insertionSortTest(){
        logger.info("插入排序测试");
        InsertionSort.insertionSort(testArr);
        Util.print(testArr);
    }


    /**
     * 随机快排测试
     */
    @Test
    public  void randomQuickSortTest(){
        logger.info("随机化快速排序测试");
        RandomQuickSort.randomQuickSort(testArr);
        Util.print(testArr);
    }


    /**
     * 快速排序测试
     */
    @Test
    public void quickSortTest(){
        logger.info("快速排序测试");
        QuickSort.quickSort(testArr);
        Util.print(testArr);
    }


    /**
     * 合并排序
     */
    @Test
    public void mergeSortTest(){
        logger.info("归并排序测试");
        MergeSort.mergeSort(testArr);
        Util.print(testArr);
    }


    @Test
    public void sortByLastName(){
        logger.info("根据last name排序");
        List<String> name = new ArrayList<>();
        name.add("Daenerys Targaryen");
        name.add("Jon Show");
        name.add("Tyrion Lannister");
        name.add("Joffrey Baratheon");
        SortByLastName.sort(name);
        logger.info("排序后的结果:{}",StringUtils.join(name,","));
    }







}
