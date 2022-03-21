package com.lis.leetcode.all;

/**
 * ClassName Solution064MinPathSum
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 * 同样的动态规划问题，在第一行和第一列上，每个元素的路径是之前所有数的和加上自身，而在其他方向，则是上一行和前一类的两个路径取较小值
 * @author Lis on 2022/3/21
 **/
public class Solution064MinPathSum {
    public int minPathSum(int[][] grid) {
        if (null == grid || grid.length <= 0) {
            return 0;
        }
        int i = 0;
        int j = 0;
        int[][] res = new int[grid.length][grid[0].length];
        res[0][0] = grid[0][0];
        for (i = 0; i < grid.length; i++) {
            for (j = 0; j < grid[0].length; j++) {
                if (i == 0 && j > 0) {
                    res[i][j] = res[i][j-1] + grid[i][j];
                } else if (j == 0 && i > 0) {
                    res[i][j] = res[i-1][j] + grid[i][j];
                } else if (i > 0 && j > 0){
                    res[i][j] = Math.min(res[i-1][j], res[i][j-1]) + grid[i][j];
                }
            }
        }
        return res[i-1][j-1];
    }

    public static void main(String[] args) {
        int[][] nums = {{1,2,3},{4,5,6}};
        Solution064MinPathSum solu = new Solution064MinPathSum();
        System.out.println(solu.minPathSum(nums));
    }
}
