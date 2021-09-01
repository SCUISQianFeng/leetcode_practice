package com.lis.leetcode.lc.base.dynamic;

/**
 * LC003
 *
 * @author Lis
 * @version 1.0
 * @date 2021-9-1 15:16
 */
public class LC003 {

  /**
   * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
   *
   * <p>
   *
   * <p>示例 1：
   *
   * <p>输入：nums = [-2,1,-3,4,-1,2,1,-5,4] 输出：6 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。 示例 2：
   *
   * <p>输入：nums = [1] 输出：1 示例 3：
   *
   * <p>输入：nums = [0] 输出：0 示例 4：
   *
   * <p>输入：nums = [-1] 输出：-1 示例 5：
   *
   * <p>输入：nums = [-100000] 输出：-100000
   *
   * <p>提示：
   *
   * <p>1 <= nums.length <= 3 * 104 -105 <= nums[i] <= 105
   *
   * <p>进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
   *
   * <p>相关标签 数组 分治 动态规划
   *
   * <p>作者：力扣 (LeetCode)
   * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn3cg3/ 来源：力扣（LeetCode）
   * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param nums
   * @return
   */
  public int maxSubArray(int[] nums) {
    if (null == nums || nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    int maxValue = nums[0];
    for (int i = 1; i < nums.length; i++) {
      dp[i] = Math.max(dp[i - 1], 0) + nums[i];
      maxValue = Math.max(dp[i], maxValue);
    }

    return maxValue;
  }

  public static void main(String[] args) {
    LC003 lc003 = new LC003();
    int[] nums = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    System.out.println(lc003.maxSubArray(nums));
  }
}
