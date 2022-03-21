package com.lis.leetcode.all;

/**
 * ClassName Solution096NumTrees
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 *  假设n个节点存在二叉排序树的个数是G(n)，1为根节点，2为根节点，...，n为根节点，当1为根节点时，其左子树节点个数为0，右子树节点个数为n-1，
 *  同理当2为根节点时，其左子树节点个数为1，右子树节点为n-2，所以可得G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)
 * @author Lis on 2022/3/22
 **/
public class Solution096NumTrees {
    public int numTrees(int n) {
        if (n <= 0 || n == 1) {
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n+1; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution096NumTrees solu = new Solution096NumTrees();
        System.out.println(solu.numTrees(1));
    }
}
