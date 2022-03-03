package com.lis.leetcode.sort;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * QuickSorrt
 *
 * @author Lis
 * @version 1.0
 * @date 2022-2-22 9:36
 */
public class QuickSort {

  private static void quickSort(List<Integer> list, int low, int high) {
    if (low < high) {
      // 第一轮排序后，比中心元素小的在左边，比中心元素大的在右边
      int position = partition(list, low, high);
      // 多左数组递归调用
      quickSort(list, low, position - 1);
      // 多右数组递归调用
      quickSort(list, position + 1, high);
    }
  }

  public static int partition(List<Integer> list, int low, int high) {
    // 取第一元素为中心元素
    int pivot = list.get(low);
    // 取最后一个元素作为指针
    int pointer = high;
    for (int i = high; i > low; i--) {
      // 将比元素pivot的元素放在左边，比pivot大的放在右边
      if (list.get(i) > pivot) {
        // 这里有两个指针， 一个是从左到右的i，一个从右到左的pointer
        // 从最后一个元素开始，比中心元素大的就交换位置
        Integer tmp = list.get(i);
        list.set(i, list.get(pointer));
        list.set(pointer, tmp);
        pointer--;
        System.out.println(Arrays.toString(list.toArray()));
      }
    }
    // 将中心元素和指针指向的元素交换位置，输入中心元素的新位置
    int tmp = list.get(pointer);
    list.set(pointer, list.get(low));
    list.set(low, tmp);
    System.out.println(Arrays.toString(list.toArray()));
    return pointer;
  }

  public static int partition(int[] array, int low, int high) {
    // 取最后一个元素作为中心元素
    int pivot = array[low];
    // 定义指向比中心元素大的指针，首先指向第一个元素
    int pointer = high;
    // 遍历数组中的所有元素，将比中心元素大的放在右边，比中心元素小的放在左边
    for (int i = high; i > low; i--) {
      if (array[i] > pivot) {
        // 需要进行值交换，是因为i指向的值比pivot大，而pointer指向的值已经比i指向的值小
        // 将比中心元素小的元素和指针指向的元素交换位置
        // 如果第一个元素比中心元素小，这里就是自己和自己交换位置，指针和索引都向下一位移动
        // 如果元素比中心元素大，索引向下移动，指针指向这个较大的元素，直到找到比中心元素小的元素，并交换位置，指针向下移动
        int temp = array[i];
        array[i] = array[pointer];
        array[pointer] = temp;
        pointer--;
      }
      System.out.println(Arrays.toString(array));
    }
    // 将中心元素和指针指向的元素交换位置
    int temp = array[pointer];
    array[pointer] = array[low];
    array[low] = temp;
    return pointer;
  }

  private static int midPoint(List<Integer> list) {
    if (list.size() < 3) {
      return 0;
    }
    int lowValue = list.get(0);
    int midValue = list.get(list.size() / 2);
    int highValue = list.get(list.size() - 1);
    Map<Integer, Integer> mapValueIdx = new HashMap<>();
    mapValueIdx.put(lowValue, 0);
    mapValueIdx.put(midValue, list.size() / 2);
    mapValueIdx.put(highValue, list.size() - 1);
    int maxValue = Math.max(Math.max(lowValue, midValue), highValue);
    int minValue = Math.min(Math.min(lowValue, midValue), highValue);
    mapValueIdx.remove(maxValue);
    mapValueIdx.remove(minValue);
    return new ArrayList<>(mapValueIdx.values()).get(0);
  }

  public static void quickSort(int[] array, int low, int high) {
    if (low < high) {
      // 获取划分子数组的位置
      int position = partition(array, low, high);
      // 左子数组递归调用
      quickSort(array, low, position - 1);
      // 右子数组递归调用
      quickSort(array, position + 1, high);
    }
  }

  public static void main(String[] args) {
    List<Integer> list1 = Stream.of(8, 3, 16, 2, 4, 5, 9, 7, 10).collect(Collectors.toList());
    System.out.println(QuickSort.midPoint(list1));
    //    QuickSort.quickSort(list1, 0, list1.size() - 1);
    //    System.out.println(Arrays.toString(list1.toArray()));
    //      int[] array = {8, 3, 16, 2, 4, 5, 9, 7};
    //      quickSort(array, 0, array.length -1);
    //      System.out.println("排序后的结果");
    //      System.out.println(Arrays.toString(array));
  }
}
