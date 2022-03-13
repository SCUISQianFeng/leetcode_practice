package com.lis.leetcode.swardoffer;

/**
 * ClassName Quiz66
 * 矩阵中的路径
 * 题目描述： 请设计一个函数， 用来判断在一个矩阵中是否存在一条包含某字符串
 * 所有字符的路径。 路径可以从矩阵中的任意一个格子开始， 每一步可以在矩阵中向
 * 左， 向右， 向上， 向下移动一个格子。 如果一条路径经过了矩阵中的某一个格子，
 * 则该路径不能再进入该格子。
 * 思路： 回溯法， 双层 for 循环， 判断每一个点， 每次递归调用上下左右四个点， 用
 * flag 标志是否已经匹配（return） ， 进行判断点的位置是否越界， 是否已经正确匹
 * 配， 判断矩阵的路径与模式串的第 index 个字符是否匹配。
 *
 * @author Lis on 2022/3/13
 **/
public class Quiz66 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        int flag[] = new int[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (helper(matrix, rows, cols, i, j, str, 0, flag))
                    return true;
            }
        }
        return false;
    }

    private boolean helper(char[] matrix, int rows, int cols, int i, int j, char[] str, int k, int[] flag) {
        int index = i * cols + j;
        if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k] || flag[index] == 1)
            return false;
        if (k == str.length - 1)
            return true;
        flag[index] = 1;
        if (helper(matrix, rows, cols, i - 1, j, str, k + 1, flag)
                || helper(matrix, rows, cols, i + 1, j, str, k + 1, flag)
                || helper(matrix, rows, cols, i, j - 1, str, k + 1, flag)
                || helper(matrix, rows, cols, i, j + 1, str, k + 1, flag)) {
            return true;
        }
        flag[index] = 0;
        return false;
    }
}
