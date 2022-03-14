package com.lis.leetcode.lc.middle.TreeAndGraph;

import com.lis.leetcode.lc.common.TreeNode;

import java.util.Arrays;

/**
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvix0d/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author lis
 * @version 1.0
 * @date 2022-3-14
 **/
public class Lc003 {
    /**
     * 前序遍历的第一个位置就是根节点
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        // 保存根节点
        for (int i = 0; i < preorder.length; i++) {
            if (root.val == inorder[i]) {
                root.left = buildTree(Arrays.copyOfRange(preorder,1, i+1), Arrays.copyOfRange(inorder, 0, i));
                root.right = buildTree(Arrays.copyOfRange(preorder,i+1, preorder.length), Arrays.copyOfRange(inorder, i+1, inorder.length));
            }
        }
        return root;

    }
    private void helper(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        TreeNode root = new TreeNode(preorder[0]);


    }

}
