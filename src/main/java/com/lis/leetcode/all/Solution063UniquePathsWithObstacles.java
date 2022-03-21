package com.lis.leetcode.all;

import java.util.Arrays;

/**
 * ClassName Solution063UniquePathsWithObstacles
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 如果一个位置被标记为1，则该位置走不通，则路径条数就是0。如果是在第一行和第一列中，则该行或该列的之后的位置全是0
 * @author Lis on 2022/3/21
 **/
public class Solution063UniquePathsWithObstacles {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (null == obstacleGrid || obstacleGrid.length <= 0 || obstacleGrid[0].length <= 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] res = new int[m][n];
        // 初始化矩阵-行
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                for (int j = i; j < m; j++) {
                    res[j][0] = 0;
                }
                break;
            } else {
                res[i][0] = 1;
            }

        }
        // 初始化矩阵-列
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                for (int j = i; j < n; j++) {
                    res[0][i] = 0;
                }
                break;
            } else {
                res[0][i] = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    res[i][j] = 0;
                } else {
                    res[i][j] = res[i-1][j] + res[i][j-1];
                }
            }

        }
        return res[m-1][n-1];

    }

    public static void main(String[] args) {
        int[][] nums = {{0,1}, {0,0}};
        Solution063UniquePathsWithObstacles solu = new Solution063UniquePathsWithObstacles();
        System.out.println(solu.uniquePathsWithObstacles(nums));
    }

}
