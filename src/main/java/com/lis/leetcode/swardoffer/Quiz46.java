package com.lis.leetcode.swardoffer;

/**
 * ClassName Quiz46
 * 求 1 到 n 的和
 * 题目描述： 求 1+2+3+…+n， 要求不能使用乘除法、 for、 while、 if、 else、
 * switch、 case 等关键字及条件判断语句（A?B:C） 。
 * 思路： 巧用递归（返回值类型为 Boolean）
 * @author Lis on 2022/3/13
 **/
public class Quiz46 {

    public int Sum_Solution(int n) {
        int sum = n;
        boolean result = (n > 0) && ((sum += Sum_Solution(n-1)) > 0);
        return sum;
    }
}
