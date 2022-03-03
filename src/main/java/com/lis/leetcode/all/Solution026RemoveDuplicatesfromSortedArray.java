package com.lis.leetcode.all;

import java.util.Objects;

/**
 * Solution026RemoveDuplicatesfromSortedArray
 *
 * @author Lis
 * @version 1.0
 * @date 2022-2-16 11:08
 */
public class Solution026RemoveDuplicatesfromSortedArray {
  public int removeDuplicates(int[] nums) {
    // 数组已经有序，不能引入额外空间做中转
    // 双指针, 右指针始终前进；值相同，右指针前进；值不同，左指针前进，将右指针指向的值赋给左指针指向的位置
    if (Objects.isNull(nums) || nums.length == 0) {
      return 0;
    }

    int leftPoint = 0;
    int rightPoint = 1;

    while (rightPoint < nums.length) {
      if (nums[leftPoint] != nums[rightPoint]) {
        nums[++leftPoint] = nums[rightPoint];
      }
      rightPoint++;
    }

    return ++leftPoint;
  }

  public static void main(String[] args) {
    Solution026RemoveDuplicatesfromSortedArray solu =
        new Solution026RemoveDuplicatesfromSortedArray();
    int[] nums = new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    int total = solu.removeDuplicates(nums);
    System.out.println(total);
  }
}
