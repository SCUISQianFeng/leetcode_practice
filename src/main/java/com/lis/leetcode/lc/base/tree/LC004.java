package com.lis.leetcode.lc.base.tree;

import com.lis.leetcode.lc.base.common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * LC004
 *
 * @author Lis
 * @version 1.0
 * @date 2021-8-31 17:46
 */
public class LC004 {

  /**
   * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
   *
   * <p>
   *
   * <p>示例： 二叉树：[3,9,20,null,null,15,7],
   *
   * <p>3 / \ 9 20 / \ 15 7 返回其层序遍历结果：
   *
   * <p>[ [3], [9,20], [15,7] ] 相关标签 树 广度优先搜索 二叉树
   *
   * <p>作者：力扣 (LeetCode)
   * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnldjj/ 来源：力扣（LeetCode）
   * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param root
   * @return
   */
  public List<List<Integer>> levelOrder(TreeNode root) {
      // 通过栈来实现，每遍历一层，就生成一个ArrayList存就一层的结果
      List<List<Integer>> allList = new ArrayList<>();
      if (null == root) {
          return allList;
      } else if(null == root.left && null == root.right) {
          allList.add(Stream.of(root.val).collect(Collectors.toList()));
      } else {
         levelOrder(Stream.of(root).collect(Collectors.toList()), allList);
      }
      return allList;
  }


  private void levelOrder(List<TreeNode> nodeList, List<List<Integer>> allList) {
      List<Integer> subList = new ArrayList<>();
      List<TreeNode> subNodeList = new ArrayList<>();
      for(TreeNode node: nodeList) {
          if (null != node) {
              subList.add(node.val);
              if (null != node.left) {
                  subNodeList.add(node.left);
              }
              if (null != node.right) {
                  subNodeList.add(node.right);
              }
          }
      }
      if (!subList.isEmpty()) {
          allList.add(subList);
      }
      if (!subNodeList.isEmpty()) {
          levelOrder(subNodeList, allList);
      }
  }

  public static void main(String[] args) {
      LC004 lc004 = new LC004();
      TreeNode node1 = new TreeNode(3);
      TreeNode node2 = new TreeNode(9);
      TreeNode node3 = new TreeNode(20);
      TreeNode node4 = new TreeNode(15);
      TreeNode node5 = new TreeNode(7);
      node3.left = node4;
      node3.right = node5;
      node1.left = node2;
      node1.right = node3;
      List<List<Integer>> result = lc004.levelOrder(node1);
      for (List<Integer> sub: result) {
        System.out.println(Arrays.toString(sub.toArray()));
      }
  }
}
