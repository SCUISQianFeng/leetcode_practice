package com.lis.leetcode.lc.base.common;

/**
 * TreeNode
 *
 * @author Lis
 * @version 1.0
 * @date 2021-8-31 14:08
 */
public class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode() {}

  public TreeNode(int val) {
    this.val = val;
  }

  public TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}
