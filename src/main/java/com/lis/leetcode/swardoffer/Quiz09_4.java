package com.lis.leetcode.swardoffer;

/**
 * ClassName Quiz09_4
 * 青蛙跳台阶(n 级)
 * 题目描述： 一只青蛙一次可以跳上 1 级台阶， 也可以跳上 2 级……它也可以跳上 n
 * 级。 求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * @author Lis on 2022/3/12
 **/
public class Quiz09_4 {
    /**
     * f(n-1) = f(n-2) + f(n-3) + ... + f(0)
     * f(n) = f(n-1) + f(n-2) + f(n-3) + ... + f(0)
     * f(n) - f(n-1) = f(n-1) => f(n) = 2(fn-1)
     * @param target
     * @return
     */
    public int JumpFloorII(int target) {
        return (int)Math.pow(2, target - 1);
    }
}
