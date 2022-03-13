package com.lis.leetcode.swardoffer;

/**
 * ClassName Quiz47
 * 不用加减乘除做加法
 * 题目描述： 写一个函数， 求两个整数之和， 要求在函数体内不得使用+、 -、 *、 /四
 * 则运算符号。
 * 思路： 利用位运算
 *
 * @author Lis on 2022/3/13
 **/
public class Quiz47 {

    public int Add(int num1, int num2) {
        while (num2 != 0) {
            // 计算个位
            int temp = num1 ^ num2;
            // 计算进位（1+1）
             num2 = (num1 & num2) << 1;
             num1 = temp;
        }
        return num1;
    }

    public static void main(String[] args) {
        Quiz47 quiz = new Quiz47();
        System.out.println(quiz.Add(6, 7));
    }
}
