package com.lis.leetcode.lc.base.dynamic;

/**
 * LC004
 *
 * @author Lis
 * @version 1.0
 * @date 2021-9-1 15:39
 */
public class LC004 {
  /**
   * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
   *
   * <p>给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
   *
   * <p>
   *
   * <p>示例 1：
   *
   * <p>输入：[1,2,3,1] 输出：4 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。   偷窃到的最高金额 = 1 + 3 = 4 。 示例 2：
   *
   * <p>输入：[2,7,9,3,1] 输出：12 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。   偷窃到的最高金额
   * = 2 + 9 + 1 = 12 。
   *
   * <p>提示：
   *
   * <p>1 <= nums.length <= 100 0 <= nums[i] <= 400 相关标签 数组 动态规划
   *
   * <p>作者：力扣 (LeetCode)
   * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnq4km/ 来源：力扣（LeetCode）
   * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param nums
   * @return
   */
  public int rob(int[] nums) {
      // 当前房间要偷，则价值是i-2加上当前房间的值；当前房间不偷，这是i-1的值（要隔一个房间偷）
      if (null == nums || nums.length == 0) {
          return 0;
      }
      if (nums.length == 1) {
          return nums[0];
      }
      if (nums.length == 2) {
          return Math.max(nums[0], nums[1]);
      }
      int[] dp = new int[nums.length];
      dp[0] = nums[0];
      dp[1] = Math.max(nums[0], nums[1]);
      for(int i = 2; i < nums.length; i++) {
          dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
      }
      return dp[nums.length-1];
  }

  public static void main(String[] args) {
      int[] nums = new int[]{2,7,9,3,1};
      LC004 lc004 = new LC004();
      System.out.println(lc004.rob(nums));
  }
}
