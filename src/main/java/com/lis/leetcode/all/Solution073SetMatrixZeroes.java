package com.lis.leetcode.all;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Solution073SetMatrixZeroes
 *
 * @author Lis
 * @version 1.0
 * @date 2022-2-21 10:23
 */
public class Solution073SetMatrixZeroes {
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

  public static void main(String[] args) {
      Solution073SetMatrixZeroes solu = new Solution073SetMatrixZeroes();

    //
      int[][] martrix = new int[3][3];
      martrix[0][0] = 1;
      martrix[0][1] = 1;
      martrix[0][2] = 1;
      martrix[1][0] = 1;
      martrix[1][1] = 0;
      martrix[1][2] = 1;
      martrix[2][0] = 1;
      martrix[2][1] = 1;
      martrix[2][2] = 1;
      solu.setZeroesOptim(martrix);
    for (int i = 0; i < martrix.length; i++) {
      System.out.println(Arrays.toString(martrix[i]));
    }
  }
}
