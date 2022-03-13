package com.lis.leetcode.swardoffer;

import java.util.ArrayList;

/**
 * ClassName Quiz65
 * 滑动窗口的最大值
 * 题目描述： 给定一个数组和滑动窗口的大小， 找出所有滑动窗口里数值的最大值
 * 思路： 两个 for 循环， 第一个 for 循环滑动窗口， 第二个 for 循环滑动窗口中的
 * 值， 寻找最大值。 还可以使用时间复杂度更低的双端队列求解。
 *
 * @author Lis on 2022/3/13
 **/
public class Quiz65 {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (num == null || size < 1 || num.length < size)
            return list;
        int length = num.length - size + 1;
        for (int i = 0; i < length; i++) {
            int current = size + i;
            int max = num[i];
            for (int j = i; j < current; j++) {
                if (max < num[j]) {
                    max = num[j];
                }
            }
            list.add(max);
        }
        return list;
    }
}
