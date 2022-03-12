package com.lis.leetcode.swardoffer;


import com.lis.leetcode.lc.base.common.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * ClassName Quiz18
 * 判断二叉树 A 中是否包含子树 B
 * 题目描述： 输入两棵二叉树 A， B， 判断 B 是不是 A 的子结构。 （ps： 我们约定空
 * 树不是任意一个树的子结构）
 * 思路： 若根节点相等， 利用递归比较他们的子树是否相等， 若根节点不相等， 则
 * 利用递归分别在左右子树中查找
 * @author Lis on 2022/3/12
 **/
public class Quiz18 {

    public boolean hasSubTree(TreeNode source, TreeNode target) {
        if (target == null) {
            return true;
        }
        if (source == null) {
            return false;
        }
        if (doesTree1HaveTree2(source, target)) {
            return true;
        }

        return hasSubTree(source.left, target) || hasSubTree(source.right, target);


    }

    public static boolean doesTree1HaveTree2(TreeNode source, TreeNode target) {
        if (source == null && target == null) {
            return true;
        }
        if (source == null || target == null) {
            return false;
        }
        if (source.val != target.val) {
            return false;
        }
        return doesTree1HaveTree2(source.left, target.left) && doesTree1HaveTree2(source.right, target.right);
    }
}
