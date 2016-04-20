package com.ymy.algorithms.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 分割字符串 保证每个子字符串都是回文 求最小的分割数
 * http://algorithms.tutorialhorizon.com/dynamic-programming-split-the-string-into-minimum-number-of-palindromes/
 * Created by yemengying on 16/4/19.
 */
public class SplitString{


    //key:字符串 value:最小分割数 将已经计算过的字符串存储起来 避免二次计算
    private static Map<String,Integer> map = new HashMap<>();

    /**
     * 利用动态规划
     * 将每个已处理过的子字符串的最小分割数在map中存储,算法时间复杂度O(n^2)
     * @param s 要分割的字符串
     * @return
     */
    public int getMinmumWithDp(String s){
        if(s == null || "".equals(s) || isPalindrome(s)){
            return 0;
        }
        int cut = Integer.MAX_VALUE;
        for(int i=1;i<s.length();i++){
            int leftNum;
            int rightNum;
            String leftStr = s.substring(0,i);
            String rightStr = s.substring(i,s.length());
            if(map.containsKey(leftStr)){
                leftNum = map.get(leftStr);
            }else{
                leftNum = getMinmumWithDp(leftStr);
                map.put(leftStr,leftNum);
            }
            if(map.containsKey(rightStr)){
                rightNum = map.get(rightStr);
            }else{
                rightNum = getMinmumWithDp(rightStr);
                map.put(rightStr,rightNum);
            }
            cut = Math.min(1+leftNum+rightNum,cut);
        }

        return cut;


    }


    /**
     * 利用递归
     * 对于一个长度为n的字符串有n-1个可分割的位置,对于每一个分割位置都有两种情况,被选择和不被选择
     * 所以算法时间复杂度为O(2^n-1)
     * @param s
     * @return
     */
    public int getMinmumWithRecursion(String s){
        if(s == null || "".equals(s) || isPalindrome(s)){
            return 0;
        }
        int cut = Integer.MAX_VALUE;
        for(int i=1;i<s.length();i++){
            cut = Math.min(cut, 1+getMinmumWithRecursion(s.substring(0,i))+getMinmumWithRecursion(s.substring(i,s.length())));
        }
        return cut;
    }

    //判断字符串是否为回文
    public boolean isPalindrome(String s){
        int n = s.length();
        for (int i=0;i<(n / 2) + 1;++i) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }







}
