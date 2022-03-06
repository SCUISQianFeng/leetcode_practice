package com.lis.leetcode.dataStructure.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * MergeSort @申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列 @设定两个指针，最初位置分别为两个已经排序序列的起始位置 @比较两个指针指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置 @重复步骤3，直到某一指针到达序列尾； @将另一序列剩下的所有元素直接复制到合并序列尾。
 *
 * @author Lis
 * @version 1.0
 * @date 2022-2-22 9:36
 */
public class MergeSort {

  private void merge(List<Integer> list1) {
    if (list1 == null) {
      return;
    }
    mergeSort(list1, 0, list1.size() - 1);
  }

  private void mergeSort(List<Integer> list1, int start, int end) {
    if (start >= end) {
      return;
    }
    // 中间点位
    int mid = (end + start) / 2;
    // 对左边数组进行递归
    mergeSort(list1, start, mid);
    // 对右边数组进行递归
    mergeSort(list1, mid + 1, end);
    // 将结果进行合并
    merge(list1, start, mid, end);
  }

  private void merge(List<Integer> list1, int start, int mid, int end) {
    // 申请新的空间
    List<Integer> newList = new ArrayList<>();
    int start1 = start;
    int end1 = mid;
    int start2 = mid + 1;
    int end2 = end;
    int pos = start1;
    int tmp = start1;
    while (start1 <= end1 && start2 <= end) {
      if (list1.get(start1) <= list1.get(start2)) {
        newList.set(pos++, list1.get(start1++));
      } else {
        newList.set(pos++, list1.get(start2++));
      }
    }
    while (start1 <= end1) {
        newList.set(pos++, list1.get(start1++));
    }
    while (start2 <= end2) {
        newList.set(pos++, list1.get(start2++));
    }
    // 将临时数组的内容拷贝到原数组中
    while(tmp <= end) {
        list1.set(tmp, newList.get(tmp++));
    }
  }

  private void swap(List<Integer> list1, int i, int j) {
    Integer tmp = list1.get(i);
    list1.set(i, list1.get(j));
    list1.set(j, tmp);
  }

  public static void main(String[] args) {
    List<Integer> list1 = Stream.of(8, 3, 16, 2, 4).collect(Collectors.toList());
    MergeSort sort = new MergeSort();
    sort.merge(list1);
    System.out.println(Arrays.toString(list1.toArray()));
  }
}
