package com.lis.leetcode.lc.base.arr;

/**
 * LC002
 *
 * @author Lis
 * @version 1.0
 * @date 2021-8-13 10:08
 */
public class LC002 {

    public int maxProfitDynamic(int[] prices) {
        // 动态规划方法
        // 初始状态 dp[0][1] = -prices[0]  dp[0][0] = 0
        // 当天交易完之后手里没有股票可能有两种情况，一种是当天没有进行任何交易，又因为当天手里没有股票，所以当天没有股票的利润只能取前一天手里没有股票的利润。一种是把当天手里的股票给卖了，既然能卖，说明手里是有股票的，所以这个时候当天没有股票的利润要取前一天手里有股票的利润加上当天股票能卖的价格。这两种情况我们取利润最大的即可，所以可以得到
        //dp[i][0]=max(dp[i-1][0],dp[i-1][1]+prices[i]);
        //当天交易完之后手里持有股票也有两种情况，一种是当天没有任何交易，又因为当天手里持有股票，所以当天手里持有的股票其实前一天就已经持有了。还一种是当天买入了股票，当天能买股票，说明前一天手里肯定是没有股票的，我们取这两者的最大值，所以可以得到
        //dp[i][1]=max(dp[i-1][1],dp[i-1][0]-prices[i]);
        //作者：数据结构和算法
        //链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2zsx1/?discussion=KwAnTs
        //来源：力扣（LeetCode）
        //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
        // 转移方程 dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i]);  dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])

        if (null == prices || prices.length == 0) {
            return 0;
        }

        int lenght = prices.length;
        int[][] dp = new int[lenght][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < lenght; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }

        return dp[lenght-1][0];

    }

    public int maxProfitGreedy(int[] prices) {
        // 贪心算法
        // 数组的值在下降时，找到局部最小值位置，取最小值
        // 数组的值在上升时，找到局部最大值位置，取最大值
        if (null == prices || prices.length == 0) {
            return 0;
        }

        int index = 0;
        int length = prices.length;
        int total = 0;

        while(index < length) {
            // 下降周期
            while (index < length - 1 && prices[index] > prices[index+1]) {
                index++;
            }
            int min = prices[index];

            // 上升周期
            while(index < length - 1 && prices[index] < prices[index + 1]) {
                index++;
            }
            total += prices[index++] - min;
        }
        return total;

    }
}
