package com.lis.leetcode.all;

import java.util.Arrays;

/**
 * ClassName Solution684FindRedundantConnection
 *
 *  树可以看成是一个连通且 无环 的 无向 图。
 *
 * 给定往一棵 n 个节点 (节点值 1～n) 的树中添加一条边后的图。添加的边的两个顶点包含在 1 到 n 中间，且这条附加的边不属于树中已存在的边。图的信息记录于长度为 n 的二维数组 edges ，edges[i] = [ai, bi] 表示图中在 ai 和 bi 之间存在一条边。
 *
 * 请找出一条可以删去的边，删除后可使得剩余部分是一个有着 n 个节点的树。如果有多个答案，则返回数组 edges 中最后出现的边
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/redundant-connection
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Lis on 2022/3/27
 **/
public class Solution684FindRedundantConnection {

    int[] parents;

    public int[] findRedundantConnection(int[][] edges) {
        // N = edges.length 一颗树的节点和边的数量应该是N=edges.length-1，从题目的描述中，去除一条边就能从图变成树，则N=edges.length
        // 1.初始化树
        int n = edges.length;
        parents = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            parents[i] = i;
        }
        // 合并节点，如果两个节点之前已经合并过，则证明存在环，返回这两个节点的边
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            if (!union(x, y)) {
                // 如果为true，说明x和y已经合并过，即已经遍历过一次，此时再被遍历就会有有相同的祖先。具体过程如下
                // {0,1,2,3} ={1,2}> {0,2,2,3} ={1,3}> {0,3,2,3} ={2,3}> 3==3
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
        // 第一次遍历时，x = parents[x], y = parents[y],但此时x和y已经合并，下次查y的祖先时，就能找到x
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

    public static void main(String[] args) {
        int[][] edges = {{1,2}, {1,3}, {2,3}};
        Solution684FindRedundantConnection solu = new Solution684FindRedundantConnection();
        System.out.println(Arrays.toString(solu.findRedundantConnection(edges)));
    }
}
