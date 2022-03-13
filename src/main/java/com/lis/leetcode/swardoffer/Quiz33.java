package com.lis.leetcode.swardoffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * ClassName Quiz33
 * 把数组中的数排成一个最小的数
 * 题目描述： 输入一个正整数数组， 把数组里所有数字拼接起来排成一个数， 打印
 * 能拼接出的所有数字中最小的一个
 * 思路： 先将整型数组转换成 String 数组， 然后将 String 数组排序， 最后将排好序
 * 的字符串数组拼接出来。 关键就是制定排序规则。 或使用比较和快排的思想， 将前
 * 面的数和最后的数比较， 若小则放到最前面， 最后再递归调用。
 *
 * @author Lis on 2022/3/13
 **/
public class Quiz33 {

    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        int len = numbers.length;
        StringBuilder sb = new StringBuilder();
        String[] str = new String[len];
        for (int i = 0; i < len; i++) {
            str[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s1.compareTo(s2);
            }
        });

        for (int i = 0; i < str.length; i++) {
            sb.append(str[i]);
        }
        return sb.toString();
    }
}
