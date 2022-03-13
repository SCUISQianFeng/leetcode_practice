package com.lis.leetcode.swardoffer;

import java.util.LinkedHashMap;

/**
 * ClassName Quiz35
 * 第一个出现一次的字符
 * 题目描述： 在一个字符串(1<=字符串长度<=10000， 全部由字母组成)中找到第一
 * 个只出现一次的字符,并返回它的位置
 * 思路： 利用 LinkedHashMap 保存字符和出现次数
 *
 * @author Lis on 2022/3/13
 **/
public class Quiz35 {
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0)
            return -1;
        char[] c = str.toCharArray();
        LinkedHashMap<Character, Integer> hash = new LinkedHashMap<Character, Integer>();
        for (char item : c) {
            if (hash.containsKey(item))
                hash.put(item, hash.get(item) + 1);
            else
                hash.put(item, 1);
        }
        for (int i = 0; i < str.length(); i++) {
            if (hash.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
