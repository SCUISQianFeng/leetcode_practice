package com.lis.leetcode.all;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 因为收尾相连，因此可以偷的范围是0 ~ n-2, 以及 1 ~ n-1
 * @author lis
 * @version 1.0
 * @date 2022-3-22
 **/
public class Solution213Rob {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // nums >= 2
        return Math.max(rob(nums, 0, len - 2), rob(nums, 1, len - 1));
    }

    private int rob(int[] nums, int start, int end) {
        int[] dp = new int[end - start +  1];
         dp[0] = nums[start];
         dp[1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            dp[i - start] = Math.max(dp[i - start - 1], dp[i - start - 2] + nums[i]);
        }
        return dp[end - start];
    }

    public static void main(String[] args) {
        int[] nums = {2,3,2};
        Solution213Rob solu = new Solution213Rob();
        System.out.println(solu.rob(nums));
    }

}
