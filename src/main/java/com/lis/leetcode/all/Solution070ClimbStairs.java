package com.lis.leetcode.all;

/**
 * ClassName Solution070ClimbStairs
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 用一个数组来维护当前台阶的可能性，当前台阶的总数等于res[n-1] + res[n-2]
 * @author Lis on 2022/3/21
 **/
public class Solution070ClimbStairs {

    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 2) {
            return n;
        }
        int[] res = new int[n];
        res[0] = 1;
        res[1] = 2;
        for (int i = 2; i < n; i++) {
            res[i] = res[i-1] + res[i-2];
        }
        return res[n-1];

    }

    public static void main(String[] args) {
        Solution070ClimbStairs solu = new Solution070ClimbStairs();
        System.out.println(solu.climbStairs(3));
    }
}
