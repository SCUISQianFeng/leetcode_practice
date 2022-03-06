package com.lis.leetcode.lc.base.sortAndsearch;

import java.util.Arrays;

/**
 * LC001
 *
 * @author Lis
 * @version 1.0
 * @date 2021-8-26 11:08
 */
public class LC001 {
  /**
   * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
   *
   * <p>请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
   *
   * <p>注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0
   * ，应忽略。nums2 的长度为 n 。
   *
   * <p>
   *
   * <p>示例 1：
   *
   * <p>输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3 输出：[1,2,2,3,5,6] 解释：需要合并 [1,2,3] 和
   * [2,5,6] 。 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。 示例 2：
   *
   * <p>输入：nums1 = [1], m = 1, nums2 = [], n = 0 输出：[1] 解释：需要合并 [1] 和 [] 。 合并结果是 [1] 。 示例 3：
   *
   * <p>输入：nums1 = [0], m = 0, nums2 = [1], n = 1 输出：[1] 解释：需要合并的数组是 [] 和 [1] 。 合并结果是 [1] 。 注意，因为 m
   * = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
   *
   * <p>提示：
   *
   * <p>nums1.length == m + n nums2.length == n 0 <= m, n <= 200 1 <= m + n <= 200 -109 <= nums1[i],
   * nums2[j] <= 109
   *
   * <p>进阶：你可以设计实现一个时间复杂度为 O(m + n) 的算法解决此问题吗？
   *
   * <p>相关标签 数组 双指针 排序
   *
   * <p>Java
   *
   * <p>作者：力扣 (LeetCode)
   * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnumcr/ 来源：力扣（LeetCode）
   * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  public void merge(int[] nums1, int m, int[] nums2, int n) {
      // 先合并，再排序
      if (nums2.length == 0) {
          return;
      } else if (nums1.length == 0 && nums2.length != 0) {
          nums1 = nums2;
      } else {
          int j = 0;
          for (int i = m; i < m + n; i++) {
              nums1[i] = nums2[j++];
          }
          int bucketSize = 5;
          bucketSort(nums1, bucketSize);
      }

  }

    public void merg2(int[] nums1, int m, int[] nums2, int n) {
        // 归并排序
        int[] newTemp = new int[m + n];
        int index = 0;
        int i = 0;
        int j = 0;
        while(i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                newTemp[index++] = nums1[i++];
            } else {
                newTemp[index++] = nums1[j++];
            }
        }
        for (;i < m; ) {
            newTemp[index++] = nums1[i++];
        }
        for(;j < n;) {
            newTemp[index++] = nums2[j++];
        }
        for (int k = 0; k < m+n; k++) {
            nums1[k] = newTemp[k];
        }

    }
    private int[] bucketSort(int[] arr, int bucketSize) {
        int maxValue = getMaxValue(arr);
        int minValue = getMinValue(arr);

        int bucketCount = (int) Math.floor((maxValue - minValue) / bucketSize) + 1;
        int[][] buckets = new int[bucketCount][0];
        for (int i = 0; i < arr.length; i++) {
            int index = (int) Math.floor((arr[i] - minValue) / bucketSize);
            buckets[index] = arrAppend(buckets[index], arr[i]);
        }

        int arrIndex = 0;
        for(int[] bucket: buckets) {
            if (bucket.length <= 0) {
                continue;
            }
            Arrays.sort(bucket);
            for(int value: bucket) {
                arr[arrIndex++] = value;
            }
        }
        return arr;
    }

    private int[] arrAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }

    private int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for(int value: arr) {
            if (value > maxValue) {
                maxValue = value;
            }
        }
        return maxValue;
    }
    private int getMinValue(int[] arr) {
        int minValue = arr[0];
        for(int value: arr) {
            if (value < minValue) {
                minValue = value;
            }
        }
        return minValue;
    }



  private int[] countingSort(int[] arr, int maxValue) {
    int bucketLen = maxValue + 1;
    int[] bucket = new int[bucketLen];

    for (int value: arr) {
        bucket[value]++;
    }
    int sortIndex = 0;
    for(int j = 0; j < bucketLen; j++) {
        while (bucket[j] > 0) {
            arr[sortIndex++] = j;
            bucket[j]--;
        }
    }
    return arr;
  }


    public static void main(String[] args) {
        int[] nums1 = new int[]{-1,0,0,3,3,3,0,0,0};
        int[] nums2 = new int[]{1,2,2};
        int m = 6;
        int n = 3;
        LC001 lc001 = new LC001();
        lc001.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
