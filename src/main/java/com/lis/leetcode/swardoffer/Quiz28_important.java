package com.lis.leetcode.swardoffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * ClassName Quiz28_important
 * 打印字符串中所有字符的排列
 * 题目描述： 输入一个字符串,按字典序打印出该字符串中字符的所有排列。 例如输
 * 入字符串 abc,则打印出由字符 a,b,c 所能排列出来的所有字符串 abc,acb,bac,bca,cab
 * 和 cba。
 * 思路： 将当前位置的字符和前一个字符位置交换， 递归。
 *
 * @author Lis on 2022/3/13
 **/
public class Quiz28_important {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }
        helper(res, 0, str.toCharArray());
        // 符合结果的输出顺序
        Collections.sort(res);
        return res;
    }

    private void helper(ArrayList<String> res, int index, char[] s) {
        if (index == s.length - 1) {
            res.add(String.valueOf(s));
            return;
        }
        for (int i = index; i < s.length; i++) {
            if (i == index || s[index] != s[i]) {
                swap(s, index, i);
                helper(res, index + 1, s);
                swap(s, index, i);
            }
        }
    }

    public void swap(char[] c, int a, int b) {
        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;
    }

    public static void main(String[] args) {
        Quiz28_important quiz = new Quiz28_important();
        System.out.println(Arrays.toString(quiz.Permutation("abc").toArray()));
    }
}
