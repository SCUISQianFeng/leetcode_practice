package com.lis.leetcode.swardoffer;

/**
 * ClassName Quiz08
 * <p>
 * 求旋转数组的最小数字
 * 题目描述： 把一个数组最开始的若干个元素搬到数组的末尾， 我们称之为数组的
 * 旋转。 输入一个非递减排序的数组的一个旋转， 输出旋转数组的最小元素。 例如
 * 数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转， 该数组的最小值为 1。 NOTE： 给出的所
 * 有元素都大于 0， 若数组大小为 0， 请返回-1。 假设数组中不存在重复元素。
 * 思路： 利用二分法， 找到数组的中间元素 mid。 如果中间元素 > 数组第一个元素，
 * 在 mid 右边搜索变化点。 如果中间元素 < 数组第一个元素， 我们需要在 mid 左边
 * 搜索变化点。 当找到变化点时停止搜索， 满足 nums[mid] > nums[mid + 1]
 * （mid+1 是最小值） 或 nums[mid - 1] > nums[mid]（mid 是最小值） 即可。
 *
 * @author Lis on 2022/3/12
 **/
public class Quiz08 {

    public static int minInReversingList(int[] array) {
        if (null == array || array.length == 0) {
            return -1;
        }
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (array[mid] < array[mid + 1] && array[mid] < array[mid - 1]) {
                return array[mid];
            }
            if (array[mid] > array[0]) {
                // 在mid的右边搜索
                low = mid + 1;
            } else if (array[mid] < array[0]) {
                high = mid - 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {3, 4, 5, 1, 2};
        System.out.println(minInReversingList(array));
    }
}
