package com.lis.leetcode.swardoffer;

/**
 * ClassName Quiz09_1
 * 斐波那契数列的应用
 * 输出斐波那契数列的第 n 项
 * 题目描述： 现在要求输入一个整数 n， 请你输出斐波那契数列的第 n 项。 n<=39
 * 思路： 递归的效率低， 使用循环方式
 * @author Lis on 2022/3/12
 **/
public class Quiz09_1 {

    public long fibonacci(int n) {
        if (n < 0) {
            return -1;
        }
        if (n <= 1) {
            return n;
        }
        int oneValue = 0;
        int twoValue = 1;
        int sum = 0;
        for (int i = 2; i <=n; i++) {
            sum = oneValue + twoValue;
            oneValue = twoValue;
            twoValue = sum;
        }
        return sum;
    }

    public long fibonacci1(int n) {
        if (n < 0) {
            return -1;
        }
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacci1(n - 1) + fibonacci1(n - 2);
    }


    public static void main(String[] args) {
        Quiz09_1 quiz = new Quiz09_1();
        System.out.println(quiz.fibonacci(10));
    }
}
