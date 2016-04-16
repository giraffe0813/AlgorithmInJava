package com.ymy.algorithms.string;

/**
 * 比较一个字符串是不是另个字符串的不同排列
 * eg: "sumit"和"tiums" 返回true
 * Created by yemengying on 16/4/16.
 */
public class PermutationString {

    public boolean isPermutation(String s1, String s2){
        if(s1 == null || s2 == null) return false;
        if(s1.length() != s2.length()) return false;
        for(int i=0;i<s1.length();i++){
            int index = s2.indexOf(s1.charAt(i));
            if(index != -1){
                s2 = s2.substring(0,index) + s2.substring(index+1,s2.length());
            }
            else{
                return false;
            }
        }
        if(s2.length() != 0){
            return false;
        }
        return true;

    }


}
