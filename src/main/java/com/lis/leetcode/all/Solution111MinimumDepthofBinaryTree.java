package com.lis.leetcode.all;

import com.lis.leetcode.lc.base.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Solution111MinimumDepthofBinaryTree
 *
 * @author Lis
 * @version 1.0
 * @date 2022-2-15 11:15
 */
public class Solution111MinimumDepthofBinaryTree {
  public int minDepth(TreeNode root) {
    if (null == root) {
      return 0;
    }
    if (root.left == null) {
      return minDepth(root.right) + 1;
    }
    // 不能使用
    // if (root.left != null) {
    //  return minDepth(root.left) + 1;
    // }这样的方式，如果左右子树都不为空，应该执行最后一行代码，但实际上只执行了第一个if判断
    if (root.right == null) {
      return minDepth(root.left) + 1;
    }
    // 左右子树都不为空，就选左右子树深度最小的
    return 1 + Math.min(minDepth(root.right), minDepth(root.left));
  }

  /**
   * 非递归实现
   *
   * @param root
   * @return
   */
  public int minDepthNoRecur(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int levelNum = 1;
    Queue<TreeNode> queue = new LinkedList<>();
    // 根结点先入队
    queue.offer(root);
    while (!queue.isEmpty()) {
        // size必须先取出来进行初始化，不然用i < queue.size(),循环就不会结束
        int size = queue.size();
      // 取出queue的元素
      for (int i = 0; i < size; i++) {
        TreeNode tmp = queue.poll();
        if (tmp.left == null && tmp.right == null) {
            // 因为是最小深度，只要这一层里面有一个节点的左右子树都是空，整个程序就结束了
          return levelNum;
        }
        if (tmp.right != null) {
          queue.offer(tmp.right);
        }
        if (tmp.left != null) {
          queue.offer(tmp.left);
        }
      }
      levelNum++;
    }
    return -1;
  }

  public static void main(String[] args) {
    Solution111MinimumDepthofBinaryTree solu = new Solution111MinimumDepthofBinaryTree();
    TreeNode node3 = new TreeNode(3);
    TreeNode node9 = new TreeNode(9);
    TreeNode node20 = new TreeNode(20);
    TreeNode node15 = new TreeNode(15);
    TreeNode node7 = new TreeNode(7);
    node3.left = node9;
    node3.right = node20;
    node20.left = node15;
    node20.right = node7;
    System.out.println(solu.minDepthNoRecur(node3));
  }
}
