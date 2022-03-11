package com.lis.leetcode.swardoffer;

/**
 * 题目描述： 在一个二维数组中， 每一行都按照从左到右递增的顺序排序， 每一列
 * 都按照从上到下递增的顺序排序。 请完成一个函数， 输入这样的一个二维数组和一
 * 个整数， 判断数组中是否含有该整数。
 * 思路： 从右上角或左下角开始找， 逐行排除， 或者用二分法查找
 */
public class Quiz03 {

    /**
     * 从数组的右上或者左下角开始
     * @param array
     * @param target
     * @return
     */
    public static boolean find1(int[][] array, int target) {
        if (null == array || array.length == 0) {
            return false;
        }
        int row = array.length;
        int col = array[0].length - 1;
        while (row < array.length && col >= 0) {
            if (array[row][col] == target) {
                return false;
            } else if (array[row][col] > target) {
                // 因为数组的元素是从左到右，从上到下升序，如果当前值大于target，先向左找
                col--;
            } else {
                // 小于target，向下找
                row++;
            }
        }
        return false;
    }

    /**
     * 二分查找法
     * @param array
     * @param target
     * @return
     */
    public static boolean find2(int[][] array, int target) {
        if (null == array || array.length == 0) {
            return false;
        }
        int low = 0;
        // 左下角-index最大值
        int high = array.length * array[0].length - 1;
        int col = array[0].length;

        while (low <= high) {
            int mid = (high + low) / 2;
            if (array[mid / col][mid % col] == target) {
                return false;
            } else if (array[mid / col][mid % col] > target) {
                // mid应该往更小的位置移动
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
