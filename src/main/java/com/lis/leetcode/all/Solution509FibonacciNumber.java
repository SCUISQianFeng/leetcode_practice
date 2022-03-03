package com.lis.leetcode.all;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName Solution509FibonacciNumber
 *斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给定 n ，请计算 F(n) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fibonacci-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Lis on 2022/3/3
 **/
public class Solution509FibonacciNumber {

    private final static Map<Integer, Integer> map = new HashMap<>();
    /**
     * 递归解法
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1 ) + fib(n - 2);

    }

    /**
     * 带备忘录的自顶向下解法
     * @param n
     * @return
     */
    public int fibWithTable1(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        if(!map.containsKey(n)) {
            map.put(n, fibWithTable1(n-1) + fibWithTable1(n-2));
        }
        return map.get(n);
    }

    /**
     * 带备忘录的自顶向下解法2
     * @param n
     * @return
     */
    public int fibWithTable2(int n) {
        int[] result = new int[n + 1];
        return helper(result, n );
    }

    private int helper(int[] result, int n) {
        if (n == 0 || n == 1 ) {
            result[n] = n;
            return n;
        }

        if (result[n] != 0) {
            return result[n];
        }
        result[n] = helper(result, n - 1) + helper(result, n - 2);
        return result[n];
    }


    /**
     * 动态规划的自底向上
     * @param n
     * @return
     */
    public int fibWithTable3(int n) {
        if (n == 0) {
            return n;
        }
        int[] result = new int[n + 1];
        result[0] = 0;
        result[1] = 1;

        for (int i = 2; i <= n; i++) {
            result[i] = result[i-1] + result[i - 2];
        }
        return result[n];
    }

    /**
     * 动态规划的自底向上，只需要保留两个值即可
     * @param n
     * @return
     */
    public int fibWithTable4(int n) {
        int prev = 0;
        int curr = 1;
        if (n == 0 || n == 1) {
            return n;
        }
        for (int i = 2; i <= n; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;

        }
        return curr;
    }


    public static void main(String[] args) {
        Solution509FibonacciNumber solu = new Solution509FibonacciNumber();
        System.out.println(solu.fibWithTable4(1000));
    }
}
