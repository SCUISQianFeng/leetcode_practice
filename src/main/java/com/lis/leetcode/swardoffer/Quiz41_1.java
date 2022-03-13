package com.lis.leetcode.swardoffer;

import java.util.ArrayList;

/**
 * ClassName Quiz41_1
 * 整数序列的查找
 * 41.1 和为 S 的连续整数序列
 * 题目描述： 输出所有和为 S 的连续正数序列。 序列内按照从小至大的顺序， 序列
 * 间按照开始数字从小到大的顺序
 * 思路： 定义两个指针， 分别递增， 寻找和为 s 的序列。
 *
 * @author Lis on 2022/3/13
 **/
public class Quiz41_1 {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (sum < 3)
            return arrayList;
        int small = 1;
        int big = 2;
        while (small < (sum + 1) / 2) {
            int s = 0;
            for (int i = small; i <= big; i++) {
                s += i;
            }
            if (s == sum) {
                for (int i = small; i <= big; i++) {
                    list.add(i);
                }
                arrayList.add(new ArrayList<>(list));
                list.clear();
                small++;
            } else {
                if (s > sum) {
                    small++;
                } else {
                    big++;
                }
            }
        }
        return arrayList;
    }
}