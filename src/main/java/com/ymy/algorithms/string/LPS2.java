package com.ymy.algorithms.string;

/**
 * 最长回文子串
 * eg:abcba的最长回文子串是abcba
 * leetcode第5题
 * Created by yemengying on 16/4/8.
 */
public class LPS2 {

    private static int length = Integer.MIN_VALUE;
    private static int start;
    private static int end;

    public static String getLps(String s){
        if(s == null || "".equals(s)) return "";
        // 中心扩展法
        for(int i = 0; i <s.length();i++){
            getLPSHelper(s,i,i);
            getLPSHelper(s,i,i+1);
        }
        return s.substring(start,end+1);
    }

    /**
     * 获得以s[i],s[j]为中心的回文字符串的长度
     * @param s
     * @param i
     * @param j
     * @return
     */
    public static void getLPSHelper(String s, int i, int j){

        while(i >= 0 && j < s.length()){
            if(s.charAt(i) == s.charAt(j)){
                if(length < j-i+1){
                    length = j-i+1;
                    start = i;
                    end = j;
                }
                i--;
                j++;
            }else{
                break;
            }
        }


    }
}
