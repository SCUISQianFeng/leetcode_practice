package com.lis.leetcode.all;

import java.util.*;

/**
 * ClassName Solution210FindOrder
 * 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
 * <p>
 * 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
 * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Lis on 2022/3/22
 **/
public class Solution210FindOrder {

    /**
     * Kahn 算法
     * 流程
     * 将入度为0的节点保存到集合S中（入度为0说明不依赖其他节点）。
     * 从集合S中取出任意一个节点n，放到结果List中。
     * 将n的后继节点入度减少1，如果入度变为0，则添加到集合S中（可以理解为从图中删除节点n及其出边，因此后继节点的入度减少了；节点入度变为0时，说明它的依赖节点都已经放好了）。
     * 不断循环直到集合S为空。
     * 检查是否所有节点都已经处理。如果有节点没处理，说明有环，无法排序。
     * 复杂度
     * 时间复杂度 O(E + V)
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 计算没门课程的入度
        // map存放每门课的后继，即学习该课程后，List<Integer>中的每门课的入度都要减1
        Map<Integer, List<Integer>> graph = new HashMap<>();
        // 存放每门课的入度
        int[] indegree = new int[numCourses];
        for (int[] e : prerequisites) {
            // e[1]和e[0]表示先学e[1]才能学e[0]，也就是学习了e[1]，则e[0]的入度减1
            int pre = e[1];
            int cur = e[0];
            List<Integer> list = graph.get(pre);
            // 还没有构建该课程的后继
            if (null == list) {
                list = new ArrayList<>();
                graph.put(pre, list);
            }
            // e[1]的后续课程新增一门
            list.add(cur);
            // e[0]的入度加1
            indegree[cur]++;
        }

        // 存放中间过程
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (indegree[i] == 0) {
                // 选出入度为0的课程，即不依赖其他课程的，也就必须最先学习的课程
                queue.add(i);
            }
        }
        // 存放最终结果
        int[] result = new int[numCourses];
        int size = 0;
        while (queue.size() > 0) {
            int node = queue.poll();
            // 先把最开始需要学习课程放进最终结果中
            result[size++] = node;
            // 去除当前节点对应的后续课程
            List<Integer> next = graph.get(node);
            if (null != next) {
                for (Integer n : next) {
                    // 后继课程的入度减1
                    indegree[n]--;
                    // 新的不依赖其他课程的
                    if (indegree[n] == 0) {
                        // FIFO
                        queue.add(n);
                    }
                }
            }
        }
        // 并不是所有的课程都被遍历了，说明存在环
        if (size != numCourses) {
            return new int[0];
        }
        return result;
    }

    /**
     * 使用深度优先算法
     * 流程
     * 从每个未访问的节点开始深度优先遍历。
     * 访问完一个节点的所有后继节点后，将该节点添加到栈中（类似树的后序遍历）。
     * 最后将栈反转即可得到结果。
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrderWithDFS(int numCourses, int[][] prerequisites) {
        // 邻接矩阵
        Set<Integer>[] graph = new Set[numCourses];
        for (int[] e : prerequisites) {
            // 还没建该课程的后继课程
            if (graph[e[1]] == null) {
                graph[e[1]] = new HashSet<>();
            }
            // 添加该课程的后继课程
            graph[e[1]].add(e[0]);
        }

        List<Integer> list = new ArrayList<>(numCourses);
        // 用于标记所有访问过的节点，已经访问过的不再重复访问。
        boolean[] globalVisited = new boolean[numCourses];
        // 用于标记本轮DFS访问过的节点，如果某一轮DFS重复访问到了某个节点，说明图中有环。
        boolean[] localVisited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, i, globalVisited, localVisited, list)) {
                return new int[0];
            }
        }
        // copy and reverse
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = list.get(numCourses - i - 1);
        }
        return result;

    }

    private boolean dfs(Set<Integer>[] graph, int node, boolean[] globalViasited, boolean[] localVisited, List<Integer> list) {
        if (localVisited[node]) {
            // 本轮已经访问过，说明存在环
            return false;
        }
        if (globalViasited[node]) {
            // 全局已经访问过，不需要再访问
            return true;
        }
        // 设置本轮访问和全局访问
        localVisited[node] = true;
        globalViasited[node] = true;
        // node的后续全部比遍历一遍
        Set<Integer> next = graph[node];
        if (null != next) {
            // 有后继节点，全部遍历一遍， 因为是递归，存在list的顺序和课程的依赖是相反的
            // 比如0->1->2->3,因为是递归，处理0，就需要先处理1，依次类推，所以先存进去的反而是3,2,1,0
            for (Integer n : next) {
                if (!dfs(graph, n, globalViasited, localVisited, list)) {
                    // 只要有一个后续检测不通过，直接返回false
                    return false;
                }
            }
        }
        // reset：该节点的深度遍历已经完成，该node要么没后继，要么该node在本轮遍历中已经结束，其他的遍历中可能还会用到
        localVisited[node] = false;
        list.add(node);
        return true;

    }


    public static void main(String[] args) {
        Solution210FindOrder solu = new Solution210FindOrder();
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(Arrays.toString(solu.findOrderWithDFS(4, prerequisites)));
    }
}
