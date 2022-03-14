package com.lis.leetcode.lc.middle.TreeAndGraph;

import com.lis.leetcode.lc.common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * @author lis
 * @version 1.0
 * @date 2022-3-14
 **/
public class LC002 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int flag = 1;
        while(!queue.isEmpty()) {
            // 取出这一层的节点
            List<Integer> valueList = new ArrayList<>();
            // 统计该层有多少节点
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode tmp = queue.poll();
                if (flag % 2 != 0) {
                    valueList.add(tmp.val);
                } else {
                    valueList.add(0, tmp.val);
                }
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }

            flag++;
            list.add(valueList);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node15 = new TreeNode(15);
        TreeNode node20 = new TreeNode(20);
        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;
        LC002 lc = new LC002();
        List<List<Integer>> lists = lc.zigzagLevelOrder(node3);
        for (List<Integer> list: lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
