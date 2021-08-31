package com.lis.leetcode.lc.base.arr;

import java.util.*;

/**
 * LC006
 *
 * @author Lis
 * @version 1.0
 * @date 2021-8-13 20:07
 */
public class LC006 {

  /**
   * 给定两个数组，编写一个函数来计算它们的交集。
   *
   * <p>
   *
   * <p>示例 1：
   *
   * <p>输入：nums1 = [1,2,2,1], nums2 = [2,2] 输出：[2,2] 示例 2:
   *
   * <p>输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4] 输出：[4,9]
   *
   * <p>说明：
   *
   * <p>输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。 我们可以不考虑输出结果的顺序。 进阶：
   *
   * <p>如果给定的数组已经排好序呢？你将如何优化你的算法？ 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
   * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
   *
   * <p>作者：力扣 (LeetCode)
   * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2y0c2/ 来源：力扣（LeetCode）
   * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  public int[] intersectWithList(int[] nums1, int[] nums2) {
    // 两个数组先排序，分别用指针移动，如果对应的值相同，则是交集；如果不同，谁对应的值小，则向前移动指针
    if (null == nums1 || null == nums1 || nums1.length == 0 || nums2.length == 0) {
      return new int[] {};
    }
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    List<Integer> interList = new ArrayList<>();

    int leftPoint = 0;
    int rightPoint = 0;
    while (leftPoint < nums1.length && rightPoint < nums2.length) {
      if (nums1[leftPoint] < nums2[rightPoint]) {
        leftPoint++;
      } else if (nums1[leftPoint] > nums2[rightPoint]) {
        rightPoint++;
      } else {
        interList.add(nums1[leftPoint]);
        leftPoint++;
        rightPoint++;
      }
    }
    int[] result = new int[interList.size()];
    for (int idx = 0; idx < result.length; idx++) {
      result[idx] = interList.get(idx);
    }
    return result;
  }

  public int[] intersectWithMap(int[] nums1, int[] nums2) {
    if (null == nums1 || null == nums1 || nums1.length == 0 || nums2.length == 0) {
      return new int[] {};
    }
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> interList = new ArrayList<>();
    for (int i = 0; i < nums1.length; i++) {
      map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
    }

    for (int j = 0; j < nums2.length; j++) {
      if (map.getOrDefault(nums2[j], 0) > 0) {
        interList.add(nums2[j]);
        map.put(nums2[j], map.get(nums2[j]) - 1);
      }
    }

    int[] result = new int[interList.size()];

    for (int idx = 0; idx < result.length; idx++) {
      result[idx] = interList.get(idx);
    }
    return result;
  }

  public static void main(String[] args) {
    LC006 lc006 = new LC006();
    //        int[] num1 = new int[]{1,2,2,1};
    //        int[] num2 = new int[]{2,2};
    int[] num1 = new int[] {4, 9, 5};
    int[] num2 = new int[] {9, 4, 9, 8, 4};
    System.out.println(Arrays.toString(lc006.intersectWithMap(num1, num2)));
  }
}
