package com.lis.leetcode.swardoffer;

import com.lis.leetcode.lc.base.common.TreeNode;

/**
 * 题目描述： 输入某二叉树的前序遍历和中序遍历的结果， 请重建出该二叉树。 假
 * 设输入的前序遍历和中序遍历的结果中都不含重复的数字。 例如输入前序遍历序列
 * {1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}， 则重建二叉树并返回。
 * 思路： 先找出根节点， 然后利用递归方法构造二叉树
 * 代码实现： 时间复杂度： O(n)， 空间复杂度： O(n)
 */
public class Quiz06 {

    /**
     * 递归
     * 前序是【 root,left, right], 中序是[left, root, right]
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if(null = pre || null == in || pre.length == 0 || in.length == 0) {

        }
    }

}
