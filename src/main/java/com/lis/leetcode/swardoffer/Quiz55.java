package com.lis.leetcode.swardoffer;

/**
 * ClassName Quiz55
 * 字符流中第一个不重复的字符
 * 题目描述： 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 思路： 借助辅助空间进行判断， 如字符数组
 *
 * @author Lis on 2022/3/13
 **/
public class Quiz55 {
    char[] chars = new char[256];
    StringBuilder sb = new StringBuilder();

    public void Insert(char ch) {
        sb.append(ch);
        chars[ch]++;
    }

    public char FirstAppearingOnce() {
        char[] str = sb.toString().toCharArray();
        for (char c : str) {
            if (chars[c] == 1) {
                return c;
            }
        }
        return '#';
    }
}
