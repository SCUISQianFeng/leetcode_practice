package com.lis.leetcode.lc.base.arr;

import java.util.HashMap;
import java.util.Map;

/**
 * LC005 只出现一次的数字
 *
 * @author Lis
 * @version 1.0
 * @date 2021-8-13 19:53
 */
public class LC005 {

  /**
   * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 说明： 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 示例 1:
   * 输入: [2,2,1] 输出: 1 示例 2: 输入: [4,1,2,1,2] 输出: 4
   */
  public int singleNumber(int[] nums) {
    if (null == nums || nums.length == 0) {
      return -1;
    }
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      if (map.containsKey(num)) {
        map.put(num, map.get(num) + 1);
      } else {
        map.put(num, 1);
      }
    }

    for (int num : map.keySet()) {
      if (map.get(num) == 1) {
        return num;
      }
    }
    return -1;
  }

  public int singleNumberWithoutExtractSpace(int[] nums) {
    if (null == nums || nums.length == 0) {
      return -1;
    }
    int single = 0;
    for (int num : nums) {
      single = single ^ num;
    }
    return single;
  }

  public static void main(String[] args) {
    LC005 lc005 = new LC005();
    int[] nums = new int[] {4, 1, 2, 1, 2};
    System.out.println(lc005.singleNumber(nums));
  }
}
