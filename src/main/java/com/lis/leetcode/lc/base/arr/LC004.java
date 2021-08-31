package com.lis.leetcode.lc.base.arr;

import java.util.HashSet;
import java.util.Set;

/**
 * LC004 存在重复元素
 *
 * @author Lis
 * @version 1.0
 * @date 2021-8-13 19:26
 */
public class LC004 {

  /**
   * 因为集合set中不能有重复的元素，如果有重复的 元素添加，就会添加失败
   *
   * @param nums
   * @return
   */
  public boolean containsDuplicate(int[] nums) {
    if (null == nums || nums.length == 0) {
      return false;
    }
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      if (!set.add(num)) {
        return true;
      }
    }
    return false;
  }
}
