package com.lis.leetcode.lc.base.arr;

/**
 * LC011
 *
 * @author Lis
 * @version 1.0
 * @date 2021-8-16 19:30
 */
public class LC011 {

  /**
   * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
   *
   * <p>你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
   *
   * <p>
   *
   * <p>示例 1：
   *
   * <p>输入：matrix = [[1,2,3],[4,5,6],[7,8,9]] 输出：[[7,4,1],[8,5,2],[9,6,3]] 示例 2：
   *
   * <p>输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
   * 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]] 示例 3：
   *
   * <p>输入：matrix = [[1]] 输出：[[1]] 示例 4：
   *
   * <p>输入：matrix = [[1,2],[3,4]] 输出：[[3,1],[4,2]]
   *
   * <p>提示：
   *
   * <p>matrix.length == n matrix[i].length == n 1 <= n <= 20 -1000 <= matrix[i][j] <= 1000
   *
   * <p>作者：力扣 (LeetCode)
   * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnhhkv/ 来源：力扣（LeetCode）
   * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */

  /**
   * 中可以看出：
   *
   * <p>(i,j)顺时针旋转90°为(j,row-1-i); 若继续旋转90°为(row-1-i,col-1-j); 再顺时针旋转90°为(col-1-j,i);
   * 可以知道将矩阵中的一个数给顺时针旋转90°，也就是将四个数互相交换位置
   *
   * <p>作者：Con.Trol.ER.
   * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnhhkv/?discussion=Mp8zDx
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  public void rotate(int[][] matrix) {
    if (null == matrix || matrix[0].length == 0) {
      return;
    }
    int row = matrix.length;
    int col = matrix[0].length;
    for (int i = 0; i < row / 2; i++) {
      for (int j = i; j < col - i - 1; j++) {
        swap(matrix, i, j, col - j - 1, i);
        swap(matrix, col - j - 1, i, row - 1 - i, col - 1 - j);
        swap(matrix, row - 1 - i, col - 1 - j, j, row - 1 - i);
      }
    }
  }

  public void swap(int[][] matrix, int r1, int c1, int r2, int c2) {
    int temp = matrix[r1][c1];
    matrix[r1][c1] = matrix[r2][c2];
    matrix[r2][c2] = temp;
  }
}
