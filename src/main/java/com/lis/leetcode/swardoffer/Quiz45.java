package com.lis.leetcode.swardoffer;

/**
 * ClassName Quiz45
 * 圆圈中最后剩下的数
 * 题目描述： 圆圈中最后剩下的数字（约瑟夫环）
 * 思路： 利用公式法： f[n] = (f[n-1] + k) mod n， 或使用循环链表实现
 * 约瑟夫环（约瑟夫问题）是一个数学的应用问题：已知 n 个人（以编号1，2，3…n分别表示）围坐在一张圆桌周围。从编号为 k 的人开始报数，
 * 数到 m 的那个人出圈；他的下一个人又从 1 开始报数，数到 m 的那个人又出圈；依此规律重复下去，直到剩余最后一个胜利者。
 *
 * @author Lis on 2022/3/13
 **/
public class Quiz45 {

    public static int lastRemain(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++) {
            // i 个人时删除数的索引等于 i-1 个人时删除数的索引+k(再对 i 取余)
            last = (last + m) % i;
        }
        return last;
    }
}
