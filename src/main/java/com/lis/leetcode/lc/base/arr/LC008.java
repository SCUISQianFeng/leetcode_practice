package com.lis.leetcode.lc.base.arr;

import java.util.Arrays;

/**
 * LC008
 *
 * @author Lis
 * @version 1.0
 * @date 2021-8-16 17:30
 */
public class LC008 {

  /**
   * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
   *
   * <p>示例:
   *
   * <p>输入: [0,1,0,3,12] 输出: [1,3,12,0,0] 说明:
   *
   * <p>必须在原数组上操作，不能拷贝额外的数组。 尽量减少操作次数。
   *
   * <p>作者：力扣 (LeetCode)
   * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2ba4i/ 来源：力扣（LeetCode）
   * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  public void moveZeroes(int[] nums) {
    if (null == nums || nums.length == 0) {
      return;
    }
    int index = 0;
    for (int i = 0; i < nums.length; i++) {
      // 一次遍历，把非零的都往前挪
      if (nums[i] != 0) {
        nums[index++] = nums[i];
      }
    }
    while (index < nums.length) {
      nums[index++] = 0;
    }
  }

  public static void main(String[] args) {
    LC008 lc008 = new LC008();
    int[] nums = new int[] {0, 1, 0, 3, 12};
    lc008.moveZeroes(nums);
    System.out.println(Arrays.toString(nums));
  }
}
