package com.lis.leetcode.swardoffer;

/**
 * ClassName Quiz14
 * 将数组中的奇数放在偶数前
 * 题目描述： 输入一个整数数组， 实现一个函数来调整该数组中数字的顺序， 使得
 * 所有的奇数位于数组的前半部分， 所有的偶数位于位于数组的后半部分， 并保证奇
 * 数和奇数， 偶数和偶数之间的相对位置不变
 * 思路： 使用双指针法， 或移动偶数位置
 * @author Lis on 2022/3/12
 **/
public class Quiz14 {

    public void reOrderArray(int[] array) {
        if (null == array || array.length == 0) {
            return;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            while(left < right && array[left] % 2 != 0) {
                // left找到偶数为止
                left++;
            }
            while (left < right && array[right] % 2 == 0) {
                //  right知道奇数为止
                right--;
            }

            if (left < right) {
                // 保证奇数在前半部分
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;
            }
        }
    }

}
