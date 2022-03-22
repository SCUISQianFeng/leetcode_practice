package com.lis.leetcode.all;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 * 测试用例的答案是一个 32-位 整数。
 *
 * 子数组 是数组的连续子序列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 用dpMax数组维护到当前值之前节点的乘积最大值，用dpMin数组维护到当前值之前节点的乘积最小值
 * 如果num[i] > 0:
 *          dpMax[i] = dpMax[i-1] * num[i] if dpMax[i-1] > 0 else num[i]
 * 如果num[i] < 0:
 *          dpMax[i] = dpMin[i-1] * nums[i] if dpMin[i-1] < 0 else num[i]
 * 综合上述两种情况，dpMax[i] = max(dpMax[i-1] * nums[i], nums[i], dpMin[i-1] * nums[i]
 * @author lis
 * @version 1.0
 * @date 2022-3-22
 **/
public class Solution152MaxProduct {
    public int maxProduct(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] dpMax = new int[len + 1];
        dpMax[0] = nums[0];
        int[] dpMin = new int[len + 1];
        dpMin[0] = nums[0];
        int maxValue = nums[0];
        for (int i = 1; i < len; i++) {
            dpMax[i] = Math.max(dpMin[i-1] * nums[i], Math.max(dpMax[i - 1] * nums[i], nums[i]));
            dpMin[i] = Math.min(dpMin[i-1] * nums[i], Math.min(dpMax[i-1] * nums[i], nums[i]));
            maxValue = Math.max(maxValue, dpMax[i]);
        }
        return maxValue;

    }

    public static void main(String[] args) {
        int[] nums = {1,2,-1,-2,2,1,-2,1,4,-5,4};
        Solution152MaxProduct solu = new Solution152MaxProduct();
        System.out.println(solu.maxProduct(nums));
    }
}
