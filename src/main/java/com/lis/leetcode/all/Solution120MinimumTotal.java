package com.lis.leetcode.all;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * <p>
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 用一个数组存下最后一行元素的个数就行，代表最后一行的每个元素的最优路径的和
 * 从底向上倒退，i行j列的值等于下一行的j列的值与下一行j+1列的值的较小值与当前节点值的和
 *
 * @author lis
 * @version 1.0
 * @date 2022-3-22
 **/
public class Solution120MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (null == triangle || triangle.size() == 0) {
            return 0;
        }
        // 总行数
        int n = triangle.size();
        // 详细说明
        // 从minimumTotalWithMatrix的结果可以看出，并不需要二维数组，只需要一个一维数组存在第一列就行
        //[11, 0, 0, 0, 0]
        //[9, 10, 0, 0, 0]
        //[7, 6, 10, 0, 0]
        //[4, 1, 8, 3, 0]
        //[0, 0, 0, 0, 0]
        //
        int[] res = new int[n + 1];
        // 在list中的最大行数的n-1
        for (int i = n - 1; i >= 0 ; i--) {
            for (int j = 0; j <= i; j++) {
                res[j] = Math.min(res[j], res[j + 1]) + triangle.get(i).get(j);
            }

        }
        return res[0];
    }

    public int minimumTotalWithMatrix(List<List<Integer>> triangle) {
        if (null == triangle || triangle.size() == 0) {
            return 0;
        }
        // 总行数
        int n = triangle.size();
        int[][] dp = new int[n + 1][n+1];
        // 在list中的最大行数的n-1

        for (int i = n-1; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list1 = Stream.of(2).collect(Collectors.toList());
        List<Integer> list2 = Stream.of(3, 4).collect(Collectors.toList());
        List<Integer> list3 = Stream.of(6, 5, 7).collect(Collectors.toList());
        List<Integer> list4 = Stream.of(4, 1, 8, 3).collect(Collectors.toList());
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);
        Solution120MinimumTotal solu = new Solution120MinimumTotal();
        System.out.println(solu.minimumTotalWithMatrix(lists));


    }
}
