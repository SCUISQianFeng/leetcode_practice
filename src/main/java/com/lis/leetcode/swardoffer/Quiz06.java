package com.lis.leetcode.swardoffer;

import com.lis.leetcode.lc.common.TreeNode;

import java.util.Arrays;

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
        if(null == pre || null == in || pre.length == 0 || in.length == 0) {
            return null;
        }
        if (pre.length != in.length) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < pre.length; i++) {
            if (in[i] == root.val) {
                // in[i]之前的全部是左子树的，in[i]之后全是右子树
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i+1), Arrays.copyOfRange(in, 0, i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i+1, pre.length), Arrays.copyOfRange(in, i+1, in.length));

            }
        }
        return root;
    }

    /**
     * 解法二： 递归（传入子数组的边界索引）
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode reConstructBinaryTree2(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        if (preorder.length != inorder.length) {
            return null;
        }

        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length);
    }

    private TreeNode helper(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR) {
        if (preL > preR || inL > inR) {
            return null;
        }

        int rootVal = preorder[preL];
        int index = 0;
        while (index <= inR && inorder[index] != rootVal) {
            index++;
        }

        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preorder, preL + 1, preL + index - inL, inorder, inL, index);
        root.right = helper(preorder, preL + index -inL + 1, preR, inorder, index + 1, inR);
        return root;
    }
}
