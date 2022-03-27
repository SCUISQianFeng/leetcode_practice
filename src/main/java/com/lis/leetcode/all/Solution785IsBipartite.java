package com.lis.leetcode.all;

/**
 * ClassName Solution785IsBipartite
 * 存在一个 无向图 ，图中有 n 个节点。其中每个节点都有一个介于 0 到 n - 1 之间的唯一编号。给你一个二维数组 graph ，其中 graph[u] 是一个节点数组，由节点 u 的邻接节点组成。形式上，对于 graph[u] 中的每个 v ，都存在一条位于节点 u 和节点 v 之间的无向边。该无向图同时具有以下属性：
 * 不存在自环（graph[u] 不包含 u）。
 * 不存在平行边（graph[u] 不包含重复值）。
 * 如果 v 在 graph[u] 内，那么 u 也应该在 graph[v] 内（该图是无向图）
 * 这个图可能不是连通图，也就是说两个节点 u 和 v 之间可能不存在一条连通彼此的路径。
 * 二分图 定义：如果能将一个图的节点集合分割成两个独立的子集 A 和 B ，并使图中的每一条边的两个节点一个来自 A 集合，一个来自 B 集合，就将这个图称为 二分图 。
 *
 * 如果图是二分图，返回 true ；否则，返回 false 。
 * 思路：
 *
 * 对节点进行着色，color == 0 表示未着色，color == 1 或 color == -1表示着色。
 * 从每个未着色的节点开始，将其着色，并进行深度优先搜索（每次深度优先搜索都会遍历完一个连通分量）。
 * 每遇到一条边，判断其另一个点的颜色：
 * 如果没有着色，就设置成相反的颜色，并继续深入搜索。
 * 如果已经着色，并且和当前点颜色相同，说明不是二分图。
 * 如果已经着色，并且和当前点颜色不同，忽略（继续循环）。
 * 其原理是，在第一次比遍历时，将u对应的节点默认依次都放在另一个数组中，在经过其他节点的继续遍历后，其中某个节点又变回和u相同的节点，
 *  则说明该节点和u是同一边的，也就是u和该节点之间存在长度不等的路径可以到达，这样就不可能是二分图
 * @author Lis on 2022/3/27
 **/
public class Solution785IsBipartite {
    public boolean isBipartite(int[][] graph) {

        int[] colors = new int[graph.length + 1];
        for (int i = 0; i <= graph.length; i++) {
            int[] road = graph[i];
            colors[i] = 1;
            if (!dfs(graph, colors, i)) {
                return false;
            }
        }
    }

    private boolean dfs(int[][] graph, int[] colors, int node) {

    }
}
