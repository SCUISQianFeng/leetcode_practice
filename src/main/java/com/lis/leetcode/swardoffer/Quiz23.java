package com.lis.leetcode.swardoffer;

import com.lis.leetcode.lc.base.common.TreeNode;

import java.util.*;

/**
 * ClassName Quiz23
 * 层序遍历二叉树
 * 题目描述： 从上往下打印出二叉树的每个节点， 同层节点从左至右打印。
 * 思路： 利用队列（链表） 辅助实现。
 * @author Lis on 2022/3/13
 **/
public class Quiz23 {
    /**
     * 解法一： 迭代， 间复杂度： O(n)， 空间复杂度： O(n)
     * @param root
     * @return
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        // 对队列中每个元素做遍历，如果有左右子节点，都先入队列，然后删除当前节点
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr.left != null) {
                queue.offer(curr.left);
            }
            if (curr.right != null) {
                queue.offer(curr.right);
            }
            list.add(curr.val);
        }
        return list;

    }

    public ArrayList<Integer> PrintFromTopToBottom2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        list.add(root.val);
        levelOrder(root, list);
        return list;
    }

    public void levelOrder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            list.add(root.left.val);
        }
        if (root.right != null) {
            list.add(root.right.val);
        }
        levelOrder(root.left, list);
        levelOrder(root.right, list);
    }

    public static void main(String[] args) {
        Quiz23 quiz = new Quiz23();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node3.left = node5;
        System.out.println(Arrays.toString(quiz.PrintFromTopToBottom(node1).toArray()));
    }
}

