package com.lis.leetcode.lc.base.tree;

import com.lis.leetcode.lc.common.TreeNode;

/**
 * LC002
 *
 * @author Lis
 * @version 1.0
 * @date 2021-8-31 15:02
 */
public class LC002 {

  /**
   * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
   *
   * <p>假设一个二叉搜索树具有如下特征：
   *
   * <p>节点的左子树只包含小于当前节点的数。 节点的右子树只包含大于当前节点的数。 所有左子树和右子树自身必须也是二叉搜索树。 示例 1:
   *
   * <p>输入: 2 / \ 1 3 输出: true 示例 2:
   *
   * <p>输入: 5 / \ 1 4   / \   3 6 输出: false 解释: 输入为: [5,1,4,null,null,3,6]。   根节点的值为 5 ，但是其右子节点值为 4
   * 。 相关标签 树 深度优先搜索 二叉搜索树 二叉树
   *
   * <p>作者：力扣 (LeetCode)
   * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn08xg/ 来源：力扣（LeetCode）
   * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param root
   * @return
   */
  public boolean isValidBST(TreeNode root) {
    // 未只考虑了左节点小于父节点，未考虑到左节点要大于爷节点
    //      if (null == root) {
    //          return true;
    //      }
    //      if ((null != root.right && root.right.val <= root.val) || (null != root.left &&
    // root.left.val >= root.val)) {
    //          return false;
    //      }
    //      return isValidBST(root.left) && isValidBST(root.right);
    if (null == root) {
      return true;
    }
    return  validBst(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  private boolean validBst(TreeNode root, long minValue, long maxValue) {
    if (null == root) {
      return true;
    }
    if (root.val <= minValue || root.val >= maxValue) {
        return false;
    }

    return validBst(root.left, minValue, root.val) && validBst(root.right, root.val, maxValue);
  }

  public static void main(String[] args) {
    LC002 lc002 = new LC002();
    TreeNode node1 = new TreeNode(1);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(5);
    TreeNode node6 = new TreeNode(6);
    node4.left = node3;
    node4.right = node6;
    node5.left = node1;
    node5.right = node4;
    System.out.println(lc002.isValidBST(node5));
  }
}
