package com.lis.leetcode.swardoffer;

import com.lis.leetcode.lc.base.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName Quiz61
 * 把二叉树打印成多行
 * 题目描述： 从上到下按层打印二叉树， 同一层结点从左至右输出。 每一层输出一
 * 行。
 * 思路： 利用辅助空间链表或队列来存储节点， 每层输出。
 * 代码实现
 *
 * @author Lis on 2022/3/13
 **/
public class Quiz61 {

    public static ArrayList<ArrayList<Integer>> printTree(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        ArrayList<Integer> tmp = new ArrayList<>();
        int start = 0;
        int end = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            tmp.add(node.val);
            // start用来判断一层的节点是不是打印完了
            start++;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (start == end) {
                start = 0;
                end = queue.size();
                res.add(new ArrayList<>(tmp));
                tmp.clear();
            }
        }
        return res;
    }
}
