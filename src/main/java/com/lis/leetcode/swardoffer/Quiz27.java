package com.lis.leetcode.swardoffer;

import com.lis.leetcode.lc.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * ClassName Quiz27
 * 二叉搜索树转换为双向链表
 * 题目描述： 输入一棵二叉搜索树， 将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点， 只能调整树中结点指针的指向。
 * 思路： 定义一个链表的尾节点， 递归处理左右子树， 最后返回链表的头节点
 *  有点项目明白，本来可以直接中序遍历，然后调整list中每个元素的左右子节点的指向就行
 * @author Lis on 2022/3/13
 **/
public class Quiz27 {

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        List<TreeNode> list = new LinkedList<>();
        midSort(pRootOfTree, list);
        for (int i = 0; i < list.size(); i++) {
            if (i < list.size() -1) {
                list.get(i).right = list.get(i+1);
            }
            if (i > 0) {
                list.get(i).left = list.get(i-1);
            }
        }
        return list.get(0);
    }

    public void midSort(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            if (root.left != null) {
                midSort(root.left, list);
            }
            list.add(root);
            if (root.right != null) {
                midSort(root.right, list);
            }
        }

    }
}
