package com.lis.leetcode.dataStructure.sort;

import java.util.List;

/**
 * commonUtils
 *
 * @author Lis
 * @version 1.0
 * @date 2022-2-22 13:54
 */
public final class CommonUtils {

  public static <T> T swap(List<T> list, int i, int j) {
    T tmp = list.get(i);
    list.set(i, list.get(j));
    list.set(j, tmp);
    return (T) list;
  }

  public static <T> T swap(T[] arr, int i, int j) {
    T tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
    return (T) arr;
  }
}
