package com.lis.leetcode.all;

/**
 * ClassName Solution053MaxSubArray
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 * 用一个数组维护当之前值的和，如果是累计的和大于0，则加上当前值，如果小于0，则用当期值替换
 * @author Lis on 2022/3/21
 **/
public class Solution053MaxSubArray {

    public int maxSubArray(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int maxValue = nums[0];
        int[] res = new int[nums.length];
        res[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i-1] > 0 ? res[i-1] + nums[i] : nums[i];
            maxValue = Math.max(maxValue, res[i]);
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int[] nums = {5,4,-1,7,8};
        Solution053MaxSubArray solu = new Solution053MaxSubArray();
        System.out.println(solu.maxSubArray(nums));
    }

}
