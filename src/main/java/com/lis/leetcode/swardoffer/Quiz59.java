package com.lis.leetcode.swardoffer;

import com.lis.leetcode.lc.base.common.TreeNode;

/**
 * ClassName Quiz59
 * 对称的二叉树
 * 题目描述： 请实现一个函数， 用来判断一颗二叉树是不是对称的。 注意： 如果一
 * 个二叉树同此二叉树的镜像是同样的， 定义其为对称的。
 * 思路： 利用递归进行判断， 若左子树的左孩子等于右子树的右孩子且左子树的右
 * 孩子等于右子树的左孩子， 并且左右子树节点的值相等， 则是对称的。
 * 代码实现： 时间复杂度： O(n)， 空间复杂度： O(n)
 *
 * @author Lis on 2022/3/13
 **/
public class Quiz59 {
    public static boolean isSymmetrical(TreeNode pRoot) {
        return pRoot == null || isCommon(pRoot.left, pRoot.right);
    }

    public static boolean isCommon(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        }
        if (leftNode == null || rightNode == null) {
            return false;
        }
        return leftNode.val == rightNode.val && isCommon(leftNode.left, rightNode.right) && isCommon(leftNode.right, rightNode.left);
    }
}
