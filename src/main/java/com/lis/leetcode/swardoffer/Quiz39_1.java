package com.lis.leetcode.swardoffer;

import com.lis.leetcode.lc.common.TreeNode;

/**
 * ClassName Quiz39_1
 * 二叉树的深度
 * 39.1 求某个二叉树的深度
 * 题目描述： 输入一棵二叉树， 求该树的深度。 从根结点到叶结点依次经过的结点
 * （含根、 叶结点） 形成树的一条路径， 最长路径的长度为树的深度。
 * 思路： 利用递归遍历分别返回左右子树深度
 * 代码实现： 时间复杂度： O(n)， 空间复杂度： O(log n)
 *
 * @author Lis on 2022/3/13
 **/
public class Quiz39_1 {
    /**
     * 二叉树的深度
     * 39.1 求某个二叉树的深度
     * 题目描述： 输入一棵二叉树， 求该树的深度。 从根结点到叶结点依次经过的结点
     * （含根、 叶结点） 形成树的一条路径， 最长路径的长度为树的深度。
     * 思路： 利用递归遍历分别返回左右子树深度
     * 代码实现： 时间复杂度： O(n)， 空间复杂度： O(log n)
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    /**
     * 39.2 判断某二叉树是否是平衡二叉树
     * 题目描述： 输入一棵二叉树， 判断该二叉树是否是平衡二叉树。
     * 思路： 平衡二叉树的条件： 左子树是平衡二叉树， 右子树是平衡二叉树， 左右子
     * 树高度不超过 1
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean condition = Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1;
        return condition && isBalanced(root.left) && isBalanced(root.right);
    }

}
