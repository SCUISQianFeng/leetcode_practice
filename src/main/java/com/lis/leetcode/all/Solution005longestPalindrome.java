package com.lis.leetcode.all;

import com.sun.deploy.util.StringUtils;

/**
 * ClassName Solution005longestPalindrome
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 判断回文，需要比较位置的i的左右字符是否相同，并且需要区分奇偶长度
 * @author Lis on 2022/3/21
 **/
public class Solution005longestPalindrome {


    public String longestPalindrome(String s) {
        if (null == s || "" == s) {
            return "";
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len = Math.max(palindrome(s, i, i), palindrome(s, i , i + 1));
            if (len > (end - start)) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);

    }

    /**
     * 返回当前字符的最大长度
     * @param s 当前字符的位置
     * @param left 字符左起位置
     * @param right 字符右起位置
     * @return int
     */
    private int palindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        Solution005longestPalindrome solu = new Solution005longestPalindrome();
        String s = "babad";
        System.out.println(solu.longestPalindrome(s));
    }
}
