package com.lis.leetcode.swardoffer;

import java.util.Arrays;

/**
 * ClassName Quiz44
 * 扑克牌的顺子
 * 题目描述： 从扑克牌中随机抽 5 张牌， 判断是不是一个顺子， 即这 5 张牌是不是
 * 连续的。 2~10 为数字本身， A 为 1， J 为 11， Q 为 12， K 为 13， 大小王可以看成
 * 任意数字。
 * 思路： 用数组记录五张扑克牌， 将数组调整为有序的， 若 0 出现的次数>=顺子的
 * 差值， 即为顺子。
 * 大小王为0，即顺子的差值小于大小王的个数，就可以大小王代替缺失的数字
 *
 * @author Lis on 2022/3/13
 **/
public class Quiz44 {

    public static boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        int count = 0;
        int diff = 0;
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == 0) {
                count++;
                continue;
            }
            if (numbers[i] == numbers[i + 1]) {
                return false;
            }
            diff += numbers[i + 1] - numbers[i] - 1;
        }
        return diff <= count;
    }
}
