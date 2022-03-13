package com.lis.leetcode.swardoffer;

import com.lis.leetcode.lc.base.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ClassName Quiz60
 * 按之字形顺序打印二叉树
 * 题目描述： 请实现一个函数按照之字形打印二叉树， 即第一行按照从左到右的顺
 * 序打印， 第二层按照从右至左的顺序打印， 第三行按照从左到右的顺序打印， 依此
 * 类推。
 * 思路： 利用两个栈的辅助空间分别存储奇数偶数层的节点， 然后打印输出。 或使
 * 用链表的辅助空间来实现， 利用链表的反向迭实现逆序输出。
 *
 * @author Lis on 2022/3/13
 **/
public class Quiz60 {

    public static List<List<Integer>> Print(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (depth % 2 == 0) {
                    // 奇数行从左到右
                    tmp.add(node.val);
                } else {
                    // 奇数行从右到左
                    tmp.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(tmp);
            depth++;
        }
        return res;
    }
}
