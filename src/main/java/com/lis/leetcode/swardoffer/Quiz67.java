package com.lis.leetcode.swardoffer;

/**
 * ClassName Quiz67
 * 机器人的运动范围
 * 题目描述： 地上有一个 m 行和 n 列的方格。 一个机器人从坐标 0,0 的格子开始移
 * 动， 每一次只能向左， 右， 上， 下四个方向移动一格， 但是不能进入行坐标和列坐
 * 标的数位之和大于 k 的格子。 请问该机器人能够达到多少个格子？
 * 思路： 利用递归实现， 每次只能走上下左右四个点， 进行判断点的位置是否越
 * 界， 点数之和是否大于 K， 是否已经走过了。
 *
 * @author Lis on 2022/3/13
 **/
public class Quiz67 {
    public int movingCount(int threshold, int rows, int cols) {
        int flag[][] = new int[rows][cols]; //记录是否已经走过
        return helper(0, 0, rows, cols, flag, threshold);
    }

    private int helper(int i, int j, int rows, int cols, int[][] flag, int threshold) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || numSum(i) + numSum(j) > threshold || flag[i][j] == 1)
            return 0;
        flag[i][j] = 1;
        return helper(i - 1, j, rows, cols, flag, threshold)
                + helper(i + 1, j, rows, cols, flag, threshold)
                + helper(i, j - 1, rows, cols, flag, threshold)
                + helper(i, j + 1, rows, cols, flag, threshold) + 1;
    }

    private int numSum(int i) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i = i / 10;
        }
        return sum;
    }
}
