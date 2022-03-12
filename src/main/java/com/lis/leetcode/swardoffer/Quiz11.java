package com.lis.leetcode.swardoffer;

/**
 * ClassName Quiz11
 * 数值的整数次方
 * 题目描述： 给定一个 double 类型的浮点数 base 和 int 类型的整数 exponent。 求
 * base 的 exponent 次方。 不得使用库函数， 不需要考虑大数问题
 * 思路： 不能用==比较两个浮点数是否相等， 因为有误差。 考虑输入值的多种情
 * 况
 * @author Lis on 2022/3/12
 **/
public class Quiz11 {

    public double Power(double base, int exponent) {
        if (equal(exponent,0)) {
            return 1.0;
        }
        if (exponent > 0) {
            return multiply(base, exponent);
        } else {
            return multiply(1/base, -exponent);
        }
    }

    private double multiply(double base, int exponent) {
        double sum = 1;
        for (int i = 0; i < exponent; i++) {
            sum = sum * base;
        }
        return sum;
    }

    private boolean equal(double a, double b) {
        return a - b < 0.0000000000001 && a - b > -0.0000000000001;
    }

    public static void main(String[] args) {
        double a = 0.000000000000000000000000000000001f;
        double b = 0.000000000000000000000000000000002f;
        // false java8不存在比较不出两个double类型差异的问题
        System.out.println(a == b);
    }
}
