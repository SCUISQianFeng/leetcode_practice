package com.lis.leetcode.lc.base.dynamic;

import jdk.nashorn.internal.ir.SplitReturn;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * LC002
 *
 * @author Lis
 * @version 1.0
 * @date 2021-9-1 11:29
 */
public class LC002 {

  /**
   * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
   *
   * <p>你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
   *
   * <p>返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
   *
   * <p>
   *
   * <p>示例 1：
   *
   * <p>输入：[7,1,5,3,6,4] 输出：5 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
   * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。 示例 2：
   *
   * <p>输入：prices = [7,6,4,3,1] 输出：0 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
   *
   * <p>提示：
   *
   * <p>1 <= prices.length <= 105 0 <= prices[i] <= 104 相关标签 数组 动态规划
   *
   * <p>作者：力扣 (LeetCode)
   * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn8fsh/ 来源：力扣（LeetCode）
   * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param prices
   * @return
   */
  public int maxProfit(int[] prices) {
      // 双数组 dp[i][0] 是i时刻不持有股票，i-1时刻也没持有，不买入股票则当前的收益为dp[i-1][0]，买入则为dp[i-1][0] - prices[i]
      // dp[i][1] 是i时刻持有股票，i-1时刻也持有，不卖出股票则当前的收益为dp[i-1][1]，卖出则为dp[i-1][1] + prices[i]

      if (null == prices || prices.length == 0) {
          return 0;
      }
      // 动态规划-初始条件
      int[][] dp = new int[prices.length][2];
      dp[0][0] = 0;
      dp[0][1] = -prices[0];
      // 动态规划-转移方程
      for(int i = 1; i < prices.length; i++) {
          dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
          dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
      }
      return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
  }
    public int maxProfitSimple(int[] prices) {
        // 当前收益只与上一期的收益相关，所以只需要两个变量，一个持有，一个是未持有

        if (null == prices || prices.length == 0) {
            return 0;
        }
        int noHold = 0;
        int hold = -prices[0];
        for(int i = 0; i < prices.length; i++) {
            noHold = Math.max(noHold, hold + prices[i]);
            hold = Math.max(hold, -prices[i]);
        }
        return noHold;
    }

  public static void main(String[] args) {
      int[] prices = new int[]{7,1,5,3,6,4};
      LC002 lc002 = new LC002();

      System.out.println(lc002.maxProfitSimple(prices));
  }
}
