package com.lis.leetcode.swardoffer;

import java.util.Queue;

/**
 * ClassName Quiz10
 * 进制中 1 的个数
 * 题目描述： 输入一个整数， 输出该数二进制表示中 1 的个数。 其中负数用补码表
 * 示。
 * 思路： a&(a-1)的结果会将 a 最右边的 1 变为 0， 直到 a = 0， 还可以先将 a&1 !=
 * 0， 然后右移 1 位， 但不能计算负数的值，
 * 7: 0 1 1 1
 * 6: 0 1 1 0
 * &: 0 1 1 0
 * @author Lis on 2022/3/12
 **/
public class Quiz10 {

    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
            System.out.println(n);
        }
        return count;
    }

    public static void main(String[] args) {
        Quiz10 quiz = new Quiz10();
        System.out.println("count:" + quiz.NumberOf1(7));
    }
}
