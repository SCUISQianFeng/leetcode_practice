package com.lis.leetcode.lc.middle.arrayAndStr;

import java.util.Arrays;

/**
 * LC002 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * <p>
 *
 * <p>示例 1：
 *
 * <p>输入：matrix = [[1,1,1],[1,0,1],[1,1,1]] 输出：[[1,0,1],[0,0,0],[1,0,1]] 示例 2：
 *
 * <p>输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]] 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 * <p>提示：
 *
 * <p>m == matrix.length n == matrix[0].length 1 <= m, n <= 200 -231 <= matrix[i][j] <= 231 - 1
 *
 * <p>进阶：
 *
 * <p>一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 *
 * <p>作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvmy42/ 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author Lis
 * @version 1.0
 * @date 2022-2-18 11:46
 */
public class LC002 {
    /**
     * 用一个额外的数组来存储有0的行和列
     * 再根据额外的数组将原数组的所在的行和列全部置为0
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int[] rowNum = new int[rowLen];
        int[] colNum = new int[colLen];

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (matrix[i][j] == 0) {
                    rowNum[i] = 1;
                    colNum[j] = 1;
                }

            }
        }
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (rowNum[i] == 1 || colNum[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * 将数组的第一行和第一列作为临时数组，从第二行和第二列开始遍历
     * 需要两个变量记录临时数组是否有0存在
     * @param matrix
     */
    public void setZeroesOptim(int[][] matrix) {
        boolean rowFirst = false;
        boolean colFirst = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        rowFirst = true;
                    }
                    if (j == 0) {
                        colFirst = true;
                    }
                    // 第一次循环只调整第一行和第一列
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        // 从第二行和第二列开始遍历，遇到0则将对应的行和列置为0
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (rowFirst) {
            Arrays.fill(matrix[0], 0);
        }
        if (colFirst) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
