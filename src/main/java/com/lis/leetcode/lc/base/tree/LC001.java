package com.lis.leetcode.lc.base.tree;

import com.lis.leetcode.lc.common.TreeNode;

/**
 * LC001
 *
 * @author Lis
 * @version 1.0
 * @date 2021-8-31 14:10
 */
public class LC001 {

  /**
   * 给定一个二叉树，找出其最大深度。
   *
   * <p>二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
   *
   * <p>说明: 叶子节点是指没有子节点的节点。
   *
   * <p>示例： 给定二叉树 [3,9,20,null,null,15,7]，
   *
   * <p>3 / \ 9 20 / \ 15 7 返回它的最大深度 3 。
   *
   * <p>相关标签 树 深度优先搜索 广度优先搜索 二叉树
   *
   * <p>作者：力扣 (LeetCode)
   * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnd69e/ 来源：力扣（LeetCode）
   * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param root
   * @return
   */
  public int maxDepth(TreeNode root) {
    if (null == root) {
      return 0;
    }
    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
  }


  public static void main(String[] args) {
    LC001 lc001 = new LC001();
    TreeNode node3 = new TreeNode(3);
    TreeNode node7 = new TreeNode(7);
    TreeNode node9 = new TreeNode(9);
    TreeNode node15 = new TreeNode(15);
    TreeNode node20 = new TreeNode(20);
    node20.left = node15;
    node20.right = node7;
    node3.left = node9;
    node3.right = node20;
    System.out.println(lc001.maxDepth(node3));
  }
}
