package com.lis.leetcode.swardoffer;

/**
 * ClassName Quiz09_3
 * 小矩形无重叠覆盖大矩形
 * 题目描述： 我们可以用 2X1 的小矩形横着或者竖着去覆盖更大的矩形。 请问用 n
 * 个 2X1 的小矩形无重叠地覆盖一个 2Xn 的大矩形， 总共有多少种方法？
 * @author Lis  on 2022/3/12
 **/
public class Quiz09_3 {

    public int RectCover(int n) {
        if (n <= 2)
            return n;
        int pre2 = 1, pre1 = 2;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = pre2 + pre1;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }
}
