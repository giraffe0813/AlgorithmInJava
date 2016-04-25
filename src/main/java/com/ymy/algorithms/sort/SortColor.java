package com.ymy.algorithms.sort;

import java.util.Arrays;
import java.util.Collections;

/**
 * 根据颜色排序 红色在白色前面 白色在蓝色前面 0代表红色 1 代表白色 2代表蓝色
 * Created by yemengying on 16/4/25.
 */
public class SortColor {

    public void sortColors(int[] nums) {
        if(nums == null || nums.length < 1) return;
        Arrays.sort(nums);
    }
}
