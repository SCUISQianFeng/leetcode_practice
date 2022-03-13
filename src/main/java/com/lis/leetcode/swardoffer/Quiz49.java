package com.lis.leetcode.swardoffer;

/**
 * ClassName Quiz49
 * 将字符串转换为整数
 * 题目描述： 将一个字符串转换成一个整数， 要求不能使用字符串转换整数的库函
 * 数。 数值为 0 或者字符串不是一个合法的数值则返回 0
 * 思路： 若为负数， 则输出负数， 字符 0 对应 48,9 对应 57， 不在范围内则返回
 * false。
 *
 * @author Lis on 2022/3/13
 **/
public class Quiz49 {

    public int StrToInt(String str) {
        if (str == null || str.length() == 0)
            return 0;
        int mark = 0;
        int number = 0;
        char[] chars = str.toCharArray();
        if (chars[0] == '-')
            mark = 1;
        for (int i = mark; i < chars.length; i++) {
            if (chars[i] == '+') {
                continue;
            }
            if (chars[i] < 48 || chars[i] > 57) {
                return 0;
            }
            number = number * 10 + chars[i] - 48;
        }
        return mark == 0 ? number : -number;
    }
}
