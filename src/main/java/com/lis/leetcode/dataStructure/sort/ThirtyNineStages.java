package com.lis.leetcode.dataStructure.sort;

import java.util.HashMap;
import java.util.Map;

/**
 * ThirtyNineStges
 *
 * @author Lis
 * @version 1.0
 * @date 2022-2-22 11:30
 */
public class ThirtyNineStages {
    private static final Map<Integer, Integer> MAP_RESULT = new HashMap();
    private static int stage(int num) {
        if (num == 1){
            return 1;
        }
        if (num == 2) {
            return 2;
        }
        if (num == 3) {
            return 4;
        }
        if (!MAP_RESULT.containsKey(num)) {
            MAP_RESULT.put(num, stage(num - 1) + stage(num - 2) + stage(num - 3));
        }
        return MAP_RESULT.get(num);
//        return stage(num - 1) + stage(num - 2) + stage(num - 3);
    }
  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    System.out.println(stage(39));
    long endTime = System.currentTimeMillis();
    System.out.println(String.format("用时: %d", (endTime - startTime) / 1000));
  }
}
