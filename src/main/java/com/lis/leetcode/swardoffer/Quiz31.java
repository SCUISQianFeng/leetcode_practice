package com.lis.leetcode.swardoffer;

/**
 * ClassName Quiz31
 * 连续子数组的最大和
 * 题目描述： 输入一个整型数组， 数组中有正数也有负数， 数组中一个或连续的多
 * 个整数组成一个子数组， 求连续子数组的最大和
 * 思路： 若和小于 0， 则将最大和置为当前值， 否则计算最大和
 * 实际上是一个动态规划的问题，当前值所在位置的和是之前和与当前值的比较，如果之前的和是负数，就直接用当前值作为最新的和
 *
 * @author Lis on 2022/3/13
 **/
public class Quiz31 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int sum = 0;
        int result = 0;
        for (int num : nums) {
            sum = sum > 0 ? sum + num : num;
            result = Math.max(sum, result);
        }
        return result;
    }
}
