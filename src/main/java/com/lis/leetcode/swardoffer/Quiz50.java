package com.lis.leetcode.swardoffer;

import com.lis.leetcode.lc.base.common.TreeNode;

/**
 * ClassName Quiz50
 * 树中两个节点的最低公共祖先
 * 题目描述： 给定一个二叉搜索树， 输入两个节点， 求树中两个节点的最低公共祖
 * 先 思
 * 路： 从根节点开始遍历树， 如果节点 p 和 q 都在右子树上， 那么以右孩子为根
 * 节点递归， 如果节点 p 和节点 q 都在左子树上， 那么以左孩子为根节点递归， 否则
 * 就意味找到节 p 和节点 q 的最低公共祖先了。
 *
 * @author Lis on 2022/3/13
 **/
public class Quiz50 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        int parentVal = root.val;
        int pVal = p.val;
        int qVal = q.val;
        if (pVal > parentVal && qVal > parentVal) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (pVal < parentVal && qVal < parentVal) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }
}
