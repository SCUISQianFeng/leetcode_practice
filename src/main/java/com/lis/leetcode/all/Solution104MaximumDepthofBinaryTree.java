package com.lis.leetcode.all;

import com.lis.leetcode.lc.base.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution104MaximumDepthofBinaryTree
 *
 * @author Lis
 * @version 1.0
 * @date 2022-2-15 14:01
 */
public class Solution104MaximumDepthofBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public int maxDepthNoRecur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int levelNum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
              int size = queue.size();
            levelNum++;
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                // 因为是最大深度，只要这一层里面有一个节点的左右子树不都是空，整个程序就还要继续运行
                if (tmp.left != null) {
                    queue.offer(tmp.right);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.left);
                }
              }
        }
        return levelNum;
    }

    public static void main(String[] args) {
        Solution104MaximumDepthofBinaryTree solu = new Solution104MaximumDepthofBinaryTree();
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;
        System.out.println(solu.maxDepthNoRecur(node3));
    }
}
