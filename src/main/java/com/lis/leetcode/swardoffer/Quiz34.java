package com.lis.leetcode.swardoffer;

/**
 * ClassName Quiz34
 * 求第 N 个丑数
 * 题目描述： 求从小到大的第 N 个丑数。 丑数是只包含因子 2、 3 和 5 的数， 习惯
 * 上我们把 1 当做是第一个丑数。
 * 思路： 乘 2 或 3 或 5， 之后比较取最小值。
 * @author Lis on 2022/3/13
 **/
public class Quiz34 {
    /**
     * 用一个数组按从小到大的顺序存下所有的丑数
     * @param n
     * @return
     */
    public static int getUglyNumber(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] arr = new int[n];
        arr[0] = 1;
        int multi2 = 0;
        int multi3 = 0;
        int multi5 = 0;
        for (int i = 0; i < n; i++) {
            int min = Math.min(arr[multi2] * 2, Math.min(arr[multi3] * 3, arr[multi5] * 5));
            arr[i] = min;
            if (arr[multi2] * 2 == min) {
                multi2++;
            }
            if (arr[multi3] * 3 == min) {
                multi3++;
            }
            if (arr[multi5] * 5 == min) {
                multi5++;
            }
        }
        return arr[n - 1];
    }

}
