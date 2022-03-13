package com.lis.leetcode.swardoffer;

/**
 * ClassName Quiz51
 * 找出重复的数
 * 题目描述： 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内， 找出数
 * 组中任意一个重复的数字
 * 思路： 快慢指针： 先用快慢两个下标都从 0 开始， 快下标每轮映射两次， 慢下标
 * 每轮映射一次， 直到两个下标再次相同。 这快下标从 0 开始， 这两个下标都继续
 * 每轮映射一次， 当这两个下标相遇时， 就是重复的数。 。 或使用辅助空间
 * （HashSet）
 * fast先多走一轮到
 * @author Lis on 2022/3/13
 **/
public class Quiz51 {

    public int findDuplicate(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        int slow = 0;
        int fast = 0;
        for (int i = 0; i < numbers.length; i++) {
            slow = numbers[slow];
            fast = numbers[numbers[fast]];
            if (fast == slow) {
                fast = 0;
                while (fast != slow) {
                    fast = numbers[fast];
                    slow = numbers[slow];
                }
                return slow;
            }
        }
        return -1;
    }


}
