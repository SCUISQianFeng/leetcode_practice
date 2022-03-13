package com.lis.leetcode.swardoffer;

/**
 * ClassName Quiz42_2
 * 将字符串循环左移 K 位
 * 题目描述： 对于一个给定的字符序列 S， 请你把其循环左移 K 位后的序列输出
 * 思路： 拼接(这种方式最直接)或反转三次字符串
 *
 * @author Lis on 2022/3/13
 **/
public class Quiz42_2 {

    public String LeftRotateString(String str, int n) {
        if (str == null || str.length() == 0)
            return str;
        String s1 = reverse(str.substring(0, n));
        String s2 = reverse(str.substring(n, str.length()));
        return reverse(s2) + reverse(s1);
    }

    public String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return String.valueOf(sb);
    }
}
