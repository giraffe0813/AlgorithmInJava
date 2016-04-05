package com.ymy.algorithms.string;

/**
 * 查找字符串数组中的字符串的最长公共前缀
 * Created by yemengying on 16/4/5.
 */
public class LCP {

    public static String longestCommonPrefix(String[] strArr){
        if(strArr.length == 0) return "";
        if(strArr.length == 1) return strArr[0];
        int minLength = Integer.MAX_VALUE;
        //查找字符串数组中 最短字符串的长度 因为公共前缀的长度不可能大于最短的字符串长度
        for(int i = 0; i <strArr.length; i++) {
            if(strArr[i].length() < minLength)
                minLength = strArr[i].length();
        }
        return longestCommonPrefixHelper(strArr, 0, minLength - 1);
    }

    public static String longestCommonPrefixHelper(String[] strArr,int begin, int end) {
        boolean flag = true;
        char ch;
        for(int i = begin; i<=end;i++) {
            ch = strArr[0].charAt(i);
            for(int j=1; j<strArr.length;j++) {
                if(strArr[j].charAt(i) != ch){
                    flag = false;
                }
            }
            if(flag) {
                return ch + longestCommonPrefixHelper(strArr, begin + 1, end);
            }
            else{
                return "";
            }
        }

        return "";
    }


}
