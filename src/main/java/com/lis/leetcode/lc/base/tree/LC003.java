package com.lis.leetcode.lc.base.tree;

import com.lis.leetcode.lc.common.TreeNode;

/**
 * LC003
 *
 * @author Lis
 * @version 1.0
 * @date 2021-8-31 15:58
 */
public class LC003 {

  /**
   * 给定一个二叉树，检查它是否是镜像对称的。
   *
   * <p>
   *
   * <p>例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
   *
   * <p>1 / \ 2 2 / \ / \ 3 4 4 3
   *
   * <p>但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
   *
   * <p>1 / \ 2 2 \ \ 3 3
   *
   * <p>进阶：
   *
   * <p>你可以运用递归和迭代两种方法解决这个问题吗？
   *
   * <p>相关标签 树 深度优先搜索 广度优先搜索 二叉树
   *
   * <p>作者：力扣 (LeetCode)
   * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn7ihv/ 来源：力扣（LeetCode）
   * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param root
   * @return
   */
  public boolean isSymmetric(TreeNode root) {
    // 一层一层的遍历，左子树的右节点和右子树的左节点， 左子树的左节点和右子树的右节点的值相同就是true
    if (null == root) {
      return true;
    }
    if (null == root.left && null == root.right) {
      return true;
    } else if (null != root.left && null != root.right && root.left.val != root.right.val) {
      return false;
    } else {
      return isSymmetric(root.left, root.right);
    }
  }

  public boolean isSymmetric(TreeNode left, TreeNode right) {
    if (null == left && null == right) {
      return true;
    } else if ((null != left && null != right && left.val != right.val)
        || (null == left && null != right)
        || (null == right && null != left)) {
      return false;
    } else {
      return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
  }

  public static void main(String[] args) {
    LC003 lc003 = new LC003();
    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(2);
    TreeNode node4 = new TreeNode(3);
    TreeNode node5 = new TreeNode(3);
    node3.right = node5;
    node2.left = node4;
    node1.left = node2;
    node1.right = node3;
    System.out.println(lc003.isSymmetric(node1));
  }
}
