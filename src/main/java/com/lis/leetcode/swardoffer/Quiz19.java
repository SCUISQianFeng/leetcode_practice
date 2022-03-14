package com.lis.leetcode.swardoffer;

import com.lis.leetcode.lc.common.TreeNode;

import java.util.Stack;


/**
 * ClassName Quiz19
 * 二叉树的镜像
 * 题目描述： 操作给定的二叉树， 将其变换为源二叉树的镜像。21
 * 思路： 使用递归或非递归方式交换每个节点的左右子树位置。
 * @author Lis on 2022/3/12
 **/
public class Quiz19 {

    /**
     * 解法一： 递归， 间复杂度： O(n)， 空间复杂度： O(n)
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }

        return left.val == right.val && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    /**
     * 解法二： 迭代， 时间复杂度： O(n)， 空间复杂度： O(n)
     * 每次都成对的压入栈中
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        stack.push(root);
        while(!stack.empty()) {
            TreeNode left = stack.pop();
            TreeNode right = stack.pop();
            if (left == null && right == null) {
                return true;
            }
            if (left != null || right != null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }
        return true;
    }
}
