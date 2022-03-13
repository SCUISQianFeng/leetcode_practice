package com.lis.leetcode.swardoffer;

import com.lis.leetcode.lc.base.common.TreeNode;

/**
 * ClassName Quiz63
 * 求二叉搜索树的第 K 小的节点
 * 题目描述： 给定一棵二叉搜索树， 请找出其中的第 k 小的结点
 * 思路： 二叉搜索树按照中序遍历的顺序打印出来正好就是排序好的顺序， 第 k 个
 * 结点就是第 K 大的节点， 分别递归查找左右子树的第 K 个节点， 或使用非递归借
 * 用栈的方式查找， 当 count=k 时返回根节点。
 *
 * @author Lis on 2022/3/13
 **/
public class Quiz63 {

    private int count = 0;

    public TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null) {
            return null;
        }
        TreeNode node = KthNode(pRoot.left, k);
        if (node != null) {
            return node;
        }
        count++;
        if (count == k) {
            return pRoot;
        }
        node = KthNode(pRoot.right, k);
        return node;
    }
}
