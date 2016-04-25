package com.ymy.algorithms.sort;

import java.util.Collections;
import java.util.List;

/**
 * 根据字符串的lastName排序
 * eg:
 * List [] = {"Daenerys Targaryen", "Jon Snow", " Tyrion Lannister", " Joffrey Baratheon"}
 * Output: [Joffrey Baratheon, Tyrion Lannister, Jon Show, Daenerys Targaryen]
 * 解法参考:http://algorithms.tutorialhorizon.com/sort-names-by-their-last-names/
 * Created by yemengying on 16/4/25.
 */
public class SortByLastName {

    public static void sort(List<String> names){
        Collections.sort(names,(s1,s2) -> s1.split(" ")[1].compareTo(s2.split(" ")[1]));
    }
}
