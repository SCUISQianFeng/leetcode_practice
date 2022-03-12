package com.lis.leetcode.all;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution52NQueen n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * <p>给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 *
 * <p>每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]] 解释：如上图所示，4 皇后问题存在两个不同的解法。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Lis
 * @version 1.0
 * @date 2022-3-4 11:40
 */
public class Solution51NQueens {
    private List<List<String>> result = new LinkedList<>();
    /**
     * 解决思路：1、将棋盘抽象为n x n的二维数组
     * 2、遍历每一行，从第一个列位置开始，放一个‘Q’,在下一行继续放Q（只要符合规则）（递归）
     * 3.回退一步
     * @param n
     * @return
     */
	public List<List<String>> solveNQueens(int n) {
        //todo
        char[][] charBoard = new char[n][n];

        for (char[] charArr: charBoard) {
            Arrays.fill(charArr, '.');
        }
        // 从第一行开始计算
        backtrack(charBoard, 0);
        return result;

	}

	private void backtrack(char[][] charBoard, int n) {
	    if (charBoard[0].length == n) {
	        // 已经遍历完
            result.add(new ArrayList<>(charToList(charBoard)));
            return;
        }
        for (int i = 0; i < charBoard[0].length; i++) {

        }
    }

	public List<String> charToList(char[][] charMatrix) {
	    List<String> strList = new LinkedList<>();

	    for(char[] charArr: charMatrix) {
	        strList.add(String.copyValueOf(charArr));
        }
	    return strList;
    }

  public static void main(String[] args) {
      Solution51NQueens solu = new Solution51NQueens();
      char[][] charMatrix = {{'a', 'b'}, {'1', '2'}};
      System.out.println(Arrays.toString(solu.charToList(charMatrix).toArray()));
  }
}
