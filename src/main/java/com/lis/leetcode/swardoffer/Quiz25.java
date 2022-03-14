package com.lis.leetcode.swardoffer;

import com.lis.leetcode.lc.common.TreeNode;

import java.util.ArrayList;

/**
 * ClassName Quiz25
 * 二叉树中和为某值的路径
 * 题目描述： 输入一颗二叉树和一个整数， 打印出二叉树中结点值的和为输入整数
 * 的所有路径。 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一
 * 条路径。
 * 思路： 先保存根节点， 然后分别递归在左右子树中找目标值， 若找到即到达叶子
 * 节点， 打印路径中的值
 * 回溯算法
 * @author Lis on 2022/3/13
 **/
public class Quiz25 {

    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return listAll;
        }
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            listAll.add(new ArrayList<>(list));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        // 回退
        list.remove(list.size() - 1);
        return listAll;
    }
}
