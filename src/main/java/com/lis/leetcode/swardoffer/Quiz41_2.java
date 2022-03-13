package com.lis.leetcode.swardoffer;

import java.util.ArrayList;

/**
 * ClassName Quiz41_2
 * 求两个乘积最小的数
 * 题目描述： 输入一个递增排序的数组和一个数字 S， 在数组中查找两个数， 是的他
 * 们的和正好是 S， 如果有多对数字的和等于 S， 输出两个数的乘积最小的。
 * 思路： 定义两个指针， 分别从前面和后面进行遍历。 间隔越远乘积越小， 所以是
 * 最先出现的两个数乘积最小
 *
 * @author Lis on 2022/3/13
 **/
public class Quiz41_2 {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if (array == null)
            return list;
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int s = array[left] + array[right];
            if (s == sum) {
                list.add(array[left]);
                list.add(array[right]);
                return list;
            } else {
                if (s > sum) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return list;
    }
}
