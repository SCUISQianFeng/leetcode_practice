package com.lis.leetcode.all;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Solution049GroupAangrams
 *
 * @author Lis
 * @version 1.0
 * @date 2022-2-21 11:44
 */
public class Solution049GroupAangrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        String s = strs[0];
        char[] sc = s.toCharArray();
        List<String> a = Stream.of("1", "2").collect(Collectors.toList());
        List<String> bn = Stream.of("1", "3").collect(Collectors.toList());
        System.out.println();
        return null;
    }

  public static void main(String[] args) {
      List<String> a = Stream.of("1", "2").collect(Collectors.toList());
      List<String> b = Stream.of("1", "2").collect(Collectors.toList());
      System.out.println(a.contains(b));
  }
}
