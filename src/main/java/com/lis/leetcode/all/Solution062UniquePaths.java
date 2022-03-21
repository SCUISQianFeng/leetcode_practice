package com.lis.leetcode.all;

/**
 * ClassName Solution062UniquePaths
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 因为只能向右和向下走，机器人在一个位置的路径条数是相同列的上一行的路径数加上相同行的前一列的路径数的和
 * 第一行和第一列的路径条数都是1
 * @author Lis on 2022/3/21
 **/
public class Solution062UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    res[i][j] = 1;
                } else if (j == 0) {
                    res[i][j] = 1;
                } else {
                    res[i][j] = res[i - 1][j] + res[i][j-1];
                }
            }

        }
        return res[m-1][n-1];

    }

    public static void main(String[] args) {
        Solution062UniquePaths solu = new Solution062UniquePaths();
        System.out.println(solu.uniquePaths(3, 2));
    }
}
