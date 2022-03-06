package com.lis.leetcode.all;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution52NQueen
 *
 * @author Lis
 * @version 1.0
 * @date 2022-3-4 11:40
 */
public class Solution51NQueen {
	private final static List<List<String>> result = new ArrayList<>();
	public List<List<String>> solveNQueens(int n) {
        // 初始化
		char[][] charBoard = new char[n][n];
		for (char[] charArr: charBoard) {
			Arrays.fill(charArr, '.');
		}
		backTrack(charBoard, 0);
        return result;
	}

	public void backTrack(char[][] charBoard, int row) {
		if (row == charBoard.length) {
			result.add(charArr2Str(charBoard));
			return ;
		}
		int n = charBoard[row].length;
		for (int col = 0; col < n; col++) {
			if (!isValid(charBoard, row, col)) {
				continue;
			}
			charBoard[row][col] = 'Q';
			// 进入下一行放皇后
			backTrack(charBoard, row + 1);
			// 撤销选择
			charBoard[row][col] = '.';
		}
	}

	/**
	 * 判断charBoard[row][col]是否可以放Q，只需要判断正下，右上，左上的位置是否冲突即可，
	 * （从左上看是，正下就可以覆盖正上，右上覆盖左下， 左上覆盖右下，又因为按列方向处理，集已经覆盖了正左正右）
	 * @param charBoard
	 * @param row
	 * @param col
	 * @return
	 */
	private boolean isValid(char[][] charBoard, int row, int col) {
		 // 正下
		int n = charBoard[row].length;
		for (int i = 0; i < n; i++) {
			if (charBoard[i][col] == 'Q') {
				return false;
			}
		}
		// 右上
		for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
			if (charBoard[i][j] == 'Q') {
				return false;
			}
		}

		// 左上
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0 ; i--, j--) {
			if (charBoard[i][j] == 'Q') {
				return false;
			}
		}

		return true;
	}

	private List<String> charArr2Str(char[][] charBoard) {
		List<String> list = new ArrayList<>();
		for (char[] charArr: charBoard) {
			list.add(String.copyValueOf(charArr));
		}
		return list;

	}

	public static void main(String[] args) {
		Solution51NQueen solu = new Solution51NQueen();
		solu.solveNQueens(1);
		for (List<String> list: result) {
			System.out.println(Arrays.toString(list.toArray()));
		}
	}
}
