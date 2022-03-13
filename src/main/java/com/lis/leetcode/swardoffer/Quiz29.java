package com.lis.leetcode.swardoffer;

/**
 * ClassName Quiz29
 * 数组中出现次数超过一半的数字
 * 题目描述： 数组中有一个数字出现的次数超过数组长度的一半， 请找出这个数
 * 字。 如果不存在则输出 0。
 * 思路： 将首次出现的数 count+1， 与之后的数进行比较， 相等则+1， 否则—1， 最
 * 后进行校验是否超过长度的一半
 * 如果一个数超过长度的一半，那么该数其他所有数相等的次数超过len/2，即相等+1，不相等-1.则最后的次数也是大于0的，所有比较到最后，候选的数字也是自己
 * @author Lis on 2022/3/13
 **/
public class Quiz29 {

    public static int moreThanHalfNum(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return checkMoreThanHalf(nums, candidate) ? candidate : 0;
    }

    private static boolean checkMoreThanHalf(int[] array, Integer number) {
        int times = 0;
        for (int i : array) {
            if (i == number) {
                times++;
            }
        }
        return times * 2 > array.length;
    }

    public static void main(String[] args) {
        Quiz29 quiz = new Quiz29();
        int[] nums = {1, 2, 3, 4, 1, 1, 1, 1, 5};
        System.out.println(quiz.moreThanHalfNum(nums));
    }
}
