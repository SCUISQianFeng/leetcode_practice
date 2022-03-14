package com.lis.leetcode.lc.middle.TreeAndGraph;

import com.lis.leetcode.lc.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * LC001
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * @author Lis
 * @version 1.0
 * @date 2022-3-3 17:36
 */
public class LC001 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
