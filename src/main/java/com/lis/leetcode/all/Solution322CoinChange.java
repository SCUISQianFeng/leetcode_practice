package com.lis.leetcode.all;

import com.sun.org.glassfish.external.amx.AMX;

import java.util.Arrays;

/**
 * Solution322CoinChange
 *
 * <p>给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * <p>计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * <p>你可以认为每种硬币的数量是无限的。
 *
 * <p>
 *
 * <p>示例 1：
 *
 * <p>输入：coins = [1, 2, 5], amount = 11 输出：3 解释：11 = 5 + 5 + 1
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Lis
 * @version 1.0
 * @date 2022-3-4 9:22
 */
public class Solution322CoinChange {
	int[] result;
	/**
	 * 递归算法：最小硬币个数等于min(amount - 1, amount - 2, amount - 5) + 1
	 * 运行超时，完全背包问题，存在重叠子问题
	 * @param coins
	 * @param amount
	 * @return
	 */
	public int coinChange(int[] coins, int amount) {
		if (amount == 0) {
			return 0;
		}
		if (amount < 0) {
			return -1;
		}
		int res = Integer.MAX_VALUE;
		for(int coin: coins) {
			int subProblem = coinChange(coins, amount - coin);
			if (subProblem == -1) {
				continue;
			}
			res = Math.min(res, subProblem + 1);
		}
		return res == Integer.MAX_VALUE ? -1 : res;
	}

	/**
	 * 带备忘录的递归实现方式
	 * @param coins
	 * @param amount
	 * @return
	 */
	public int coinChangeWithTable(int[] coins, int amount) {
		result = new int[amount + 1];
		Arrays.fill(result, -666);
		return dp(coins, amount);
	}

	private int dp(int[] coins, int amount) {
		if (amount == 0) {
			result[0] = 0;
			return 0;
		}
		if (amount < 0) {
			return -1;
		}
		if (result[amount] != -666) {
			return result[amount];
		}
		int res = Integer.MAX_VALUE;
		for (int coin: coins) {
			int subProblem = dp(coins, amount - coin);
			if (subProblem == -1) {
				continue;
			}
			res = Math.min(res, subProblem + 1);
		}
		result[amount] = (res == Integer.MAX_VALUE ? -1 : res);
		return result[amount];
	}

	/**
	 * 自底向上的实现方式，将amount做成一个列表，位置i的值就是位置i-1, i-2, i-5的值的最小值
	 * @param coins
	 * @param amount
	 * @return
	 */
	public int coinChangeWithDP(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount+1);
		dp[0] = 0;
	    for (int i = 0; i <= amount; i++) {
	    	for (int coin: coins) {
	    		if (i - coin < 0) {
	    			continue;
			    }
	    		dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
		    }
	    }
	    return (dp[amount] == amount + 1) ? -1 : dp[amount];
	}

}
