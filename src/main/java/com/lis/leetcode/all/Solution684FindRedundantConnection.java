package com.lis.leetcode.all;

/**
 * ClassName Solution684FindRedundantConnection
 *
 * @author Lis on 2022/3/27
 **/
public class Solution684FindRedundantConnection {

    int[] parents;

    public int[] findRedundantConnection(int[][] edges) {
        // N = edges.length 一颗树的节点和边的数量应该是N=edges.length-1，从题目的描述中，去除一条边就能从图变成树，则N=edges.length
        // 1.初始化树
        int n = edges.length;
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        // 合并节点，如果两个节点之前已经合并过，则证明存在环，返回这两个节点的边
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            if (!union(x, y)) {
                return edge;
            }
        }
        return new int[]{-1, -1};


    }

    /**
     * 合并两个节点，如果已经合并过，返回true
     * @param x 节点
     * @param y 节点
     * @return 是否合并过
     */
    private boolean union(int x, int y) {
        // 分别找到x和y的祖先节点
        x = findRoot(x);
        y = findRoot(y);
        if (x == y) {
            // 有共同的祖先节点
            return false;
        }
        // x和y没有共同的祖先，两个不同的连通部分进行合并
        parents[x] = y;
        return true;
    }

    /**
     * 找到x的父节点
     * @param x 源节点
     * @return x的父节点
     */
    private int findRoot(int x) {
        // x = parents[x]: x是根节点
        while (x != parents[x]) {
            // 每个节点只需要管自己的父节点就行
            parents[x] = parents[parents[x]];
            x = parents[x];
        }
        return x;
    }
}
