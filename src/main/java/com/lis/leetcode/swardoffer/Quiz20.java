package com.lis.leetcode.swardoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName Quiz20
 * 顺时针打印矩阵
 * 题目描述： 输入一个矩阵， 按照从外向里以顺时针的顺序依次打印出每一个数
 * 字， 例如， 如果输入如下 4X4 矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次
 * 打印出数字 1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * 思路： 按层模拟： 终止行号大于起始行号， 终止列号大于起始列号，
 * 代码实现： 时间复杂度： O(n)， 空间复杂度： O(n)， 其中 n 表示矩阵元素个数
 *
 * @author Lis on 2022/3/12
 **/
public class Quiz20 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int r1 = 0;
        int r2 = matrix.length - 1;
        int c1 = 0;
        int c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            // 从左往右
            for (int c = c1; c <= c2; c++) {
                res.add(matrix[r1][c]);
            }
            // 从上到下
            for (int r = r1; r <= r2; r++) {
                res.add(matrix[r][c2]);
            }
            if (r1 < r2 && c1 < c2) {
                // 从右往左
                for (int c = c2; c > c1; c--) {
                    res.add(matrix[r2][c]);
                }
                // 从下到上
                for (int r = r2; r > r1; r--) {
                    res.add(matrix[r][c1]);
                }
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return res;
    }
}
