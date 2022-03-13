package com.lis.leetcode.swardoffer;

/**
 * ClassName Quiz40
 * 找出只出现一次的数字
 * 题目描述： 一个整型数组里除了两个数字之外， 其他的数字都出现了两次。 请写
 * 程序找出这两个只出现一次的数字。
 * 思路： 两个相同的数异或后为 0， 一个数和 0 异或还是它本身， 将所有数异或后即
 * 得到 A、 B 异或的结果， 然后求得 1 在该数最右边出现的 index， 然后判断每个数
 * 右移 index 后是不是 1。
 *
 * @author Lis on 2022/3/13
 **/
public class Quiz40 {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array == null)
            return;
        num1[0] = 0;
        num2[0] = 0;
        int number = array[0];
        for (int i = 1; i < array.length; i++)
            number ^= array[i];
        // 异或后的数 1 出现在第几位
        int index = 0;
        while ((number & 1) == 0) {
            number = number >> 1;
            index++;
        }
        for (int i = 0; i < array.length; i++) {
            boolean isBit = ((array[i] >> index) & 1) == 0;
            if (isBit) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }
}
