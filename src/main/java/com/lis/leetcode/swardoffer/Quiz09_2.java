package com.lis.leetcode.swardoffer;

/**
 * ClassName Quiz09_2
 * 青蛙跳台阶(1 或 2 级)
 * 题目描述： 一只青蛙一次可以跳上 1 级台阶， 也可以跳上 2 级。 求该青蛙跳上一
 * 个 n 级的台阶总共有多少种跳法。
 * 思路： 斐波那契数列思想
 * @author Lis on 2022/3/12
 **/
public class Quiz09_2 {
    /**
     * 斐波那契数列思想
     * @param n
     * @return
     */
    public int JumpFloor(int n) {
        if (n < 3) {
            return n;
        }
        int result = 0;
        int oneValue = 1;
        int twoValue = 2;
        for (int i = 3; i <= n; i++) {
            result = oneValue + twoValue;
            oneValue = twoValue;
            twoValue = result;
        }
        return result;
    }

    /**
     * 可以一步一台阶，两步一台阶，三步一台阶
     * @param n
     * @return
     */
    public int JumpFloor3(int n) {
        if (n < 0) {
            return -1;
        }
        if (n < 2) {
            return n;
        }
        if (n == 3) {
            return 4;
        }
        int result = 0;
        int oneValue = 1;
        int twoValue = 2;
        int threeValue = 4;
        for (int i = 4; i <= n; i++) {
            result = oneValue + twoValue + threeValue;
            oneValue = twoValue;
            twoValue = threeValue;
            threeValue = result;
        }
        return result;

    }

    public int JumpFloor3_1(int n) {
        if (n < 0) {
            return -1;
        }
        if (n <= 2) {
            return n;
        }
        if (n == 3) {
            return 4;
        }
        return JumpFloor3_1(n - 1) + JumpFloor3_1(n - 2) + JumpFloor3_1(n - 3);
    }

    public static void main(String[] args) {
        Quiz09_2 quiz = new Quiz09_2();
        System.out.println(quiz.JumpFloor3(10));
    }
}
