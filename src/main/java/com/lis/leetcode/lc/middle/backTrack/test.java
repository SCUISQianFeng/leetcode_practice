package com.lis.leetcode.lc.middle.backTrack;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * test
 *
 * @author Lis
 * @version 1.0
 * @date 2021-9-1 20:12
 */
public class test {

  public static void main(String[] args) {
//      ArrayList<Integer> arrayList = new ArrayList();
//      arrayList.add(1);
//      arrayList.add(2);
//      arrayList.add(3);
//      arrayList.add(3);
//      arrayList.add(4);
//      arrayList.add(5);
//      Iterator<Integer> iterator = arrayList.iterator();
//      while (iterator.hasNext()) {
//          Integer value = iterator.next();
//          if (value.equals(3)) {
//              iterator.remove();
//          }
//          System.out.println("当前arrayList是"+arrayList.toString());
//      }

      List<String> jl = Stream.of("11", "22").collect(Collectors.toList());
      List<String> cx = Stream.of("11").collect(Collectors.toList());
      jl.removeAll(cx);
      for (String st: jl) {
          System.out.println(st);
      }
  }
}
