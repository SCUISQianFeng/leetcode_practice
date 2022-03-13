package com.lis.leetcode.swardoffer;

import java.util.Arrays;

/**
 * ClassName Quiz24
 * 后序遍历二叉搜索树
 * 题目描述： 输入一个整数数组， 判断该数组是不是某二叉搜索树的后序遍历的结
 * 果。 如果是则输出 Yes,否则输出 No。 假设输入的数组的任意两个数字都互不相
 * 同。
 * 思路： 先找到右子树的开始位置， 然后分别进行左右子树递归处理。
 * 二叉搜索树是左子树的值比根节点小，右节点比根节点大
 * @author Lis on 2022/3/13
 **/
public class Quiz24 {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return verify(sequence, 0, sequence.length - 1);
    }

    private boolean verify(int[] sequence, int first, int last) {
        if (last - first <= 1) {
            // 不够两个元素
            return false;
        }
        int root = sequence[last];
        int cutIndex = first;

        while (cutIndex < last && sequence[cutIndex] < root) {
            // 找到左右子树的分界点, first~cutIndex之间的元素都是比root小的
            cutIndex++;
        }
        for (int i = cutIndex+1; i <= last; i++) {
            //  cutIndex~last都是右子树的节点，应该都比root大
            if (sequence[i] < root) {
                return false;
            }
        }
        return verify(sequence, first, cutIndex) && verify(sequence, cutIndex + 1, last);
    }
}
