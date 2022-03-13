package com.lis.leetcode.swardoffer;

import java.util.Arrays;

/**
 * ClassName Quiz38
 * 求某个数在数组中出现次数
 * 题目描述： 统计一个数字在排序数组中出现的次数。
 * 思路： 利用二分查找+递归思想， 进行寻找。 当目标值与中间值相等时进行判断
 * 先找到这个数，再统计这个数出现的次数
 *
 * @author Lis on 2022/3/13
 **/
public class Quiz38 {
    public static int getNumberOfK(int[] arraySorted, int k) {
        if (arraySorted == null || arraySorted.length == 0) {
            return 0;
        }
        if (arraySorted.length == 1) {
            return arraySorted[0] == k ? 1 : 0;
        }
        int result = 0;
        int mid = arraySorted.length / 2;
        if (k < arraySorted[mid]) {
            result += getNumberOfK(Arrays.copyOfRange(arraySorted, 0, mid), k);
        } else if (k > arraySorted[mid]) {
            result += getNumberOfK(Arrays.copyOfRange(arraySorted, mid, arraySorted.length), k);
        } else {
            result += getCount(arraySorted, mid);
        }
        return result;
    }

    private static int getCount(int[] arraySorted, int mid) {
        int k = arraySorted[mid];
        int result = 0;
        for (int i = mid; i < arraySorted.length; i++) {
            if (arraySorted[i] == k) {
                result++;
            } else {
                break;
            }
        }
        for (int i = mid - 1; i >= 0; i--) {
            if (arraySorted[i] == k) {
                result++;
            } else {
                break;
            }
        }
        return result;
    }
}
