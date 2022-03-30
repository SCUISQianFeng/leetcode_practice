package com.lis.leetcode.all;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 有 n 个网络节点，标记为 1 到 n。
 * 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。
 * 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/network-delay-time
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 *
 * @author lis
 * @version 1.0
 * @date 2022-3-24
 **/
public class Solution743NetworkDelayTime {
    /**
     * DFS思路
     * 一个数组维护节点是否已经访问过（值初始化为-1）并保存从节点k到该节点的最小时间，最后取数组中的最大值即可
     * @param times times[i] = [from, to ,time]
     * @param n 网络节点数
     * @param k 从节点k出发
     * @return
     * @version 1.0
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        if (null == times || times.length == 0 || n <= 0 || k <= 0) {
            return -1;
        }
        // graph[i]: List<int[]>, [to node, w]
        List<int[]>[] graph = new List[n+1];
        int[] timeResult = new int[n + 1];
        Arrays.fill(timeResult, -1);
        timeResult[k] = 0;
        for (int i = 0; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        for(int[] timeArr : times) {
            int from = timeArr[0];
            int to = timeArr[1];
            int time = timeArr[2];
            // 将每个节点的前驱节点全部存储起来，方便后续做遍历
            // 表示成对于当前节点，所有的入度节点和时间
            graph[from].add(new int[]{to, time});
        }
        // DFS遍历整个图，计算每个节点的入度加上time的最小值
        dfs(graph, timeResult, k );
        int maxValue = -1;
        // 第一个节点是空的 timeResult的长度是n+1
        for (int i = 1; i < timeResult.length; i++) {
            if (timeResult[i] == -1) {
                // 没遍历到，无法算出最大时间
                return -1;
            }
            maxValue = Math.max(maxValue, timeResult[i]);
        }
        return maxValue;
    }

    public void dfs(List<int[]>[] graph, int[] time, int node) {
        for (int[] t : graph[node]) {
            int to = t[0], w = t[1];
            int newTime = time[node] + w;
            if (time[to] != -1 && newTime >= time[to]) {
                continue;
            }
            time[to] = newTime;
            dfs(graph, time, to);
        }
    }

    public static void main(String[] args) {
        Solution743NetworkDelayTime solu = new Solution743NetworkDelayTime();
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        System.out.println(solu.networkDelayTime(times, 4, 2));
    }
}
