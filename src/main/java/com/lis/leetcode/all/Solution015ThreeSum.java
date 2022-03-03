package com.lis.leetcode.all;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution015ThreeSum
 *
 * @author Lis
 * @version 1.0
 * @date 2022-2-15 16:29
 */
public class Solution015ThreeSum {

  /**
   * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i !=
   * j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
   *
   * <p>Notice that the solution set must not contain duplicate triplets. 设计思路： 1、先把列表进行从小到大的排序
   * 2、遍历排序后的数组，将当前值（下标为i）和0做差值的target 3、将用两个index（front和end），分别指向i+1和sums.length()-1,
   * 4、如果sums[i]和sums[j]的和等于target，则返回三个index，若小于target，i向右移，若大于target，j向左移
   *
   * @param nums
   * @return
   */
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> listNest = new ArrayList<>();
    if (nums.length < 3) {
      // 直接返回空
      return listNest;
    }
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      Integer num1 = nums[i];
      if (num1 > 0) {
        // 因为是有序的，当nums[1]为正数时，其他两个数不可能相加是负数
        break;
      }
      if (i > 0 && nums[i] == nums[i - 1]) {
        // 避免重复
        continue;
      }
      Integer target = -num1;
      // 两个指针分别知道i的后一位和列表的最后一位
      int front = i + 1;
      int end = nums.length - 1;

      while (front < end) {
        int sumOfTwo = nums[front] + nums[end];
        if (sumOfTwo == target) {
          listNest.add(Arrays.asList(nums[i], nums[front], nums[end]));
          front++;
          end--;
          // 这里需要做一个防重复的处理
          while (front < end && nums[front] == nums[front - 1]) {
            // 相同的数值，第一个指针从左到右前进一步
            front++;
          }
          while (front < end && nums[end] == nums[end + 1]) {
            // 相同的数值，第一个指针从右到左前进一步
            end--;
          }

        } else if (sumOfTwo > target) {
          end--;
        } else {
          front++;
        }
      }
    }
    return listNest;
  }

  public static void main(String[] args) {
    //      int[] arr = new int[]{-1,0,1,2,-1,-4};
    //      int[] arr = new int[]{0,0,0,0};
    //      int[] arr = new int[]{1,-1,-1,0};
    int[] arr = new int[] {-2, 0, 1, 1, 2};
    Solution015ThreeSum solu = new Solution015ThreeSum();
    System.out.println(solu.threeSum(arr));
  }
}
