package com.lis.leetcode.all;

import com.lis.leetcode.lc.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 * 生成树，依次取1~n的值作为根节点，则1~-i-1是左子树，i+1~n是右子树
 * @author lis
 * @version 1.0
 * @date 2022-3-22
 **/
public class Solution095GenerateTrees {

    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new ArrayList<TreeNode>();
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> all_trees = new ArrayList<>();
        //此时没有数字，将 null 加入结果中
        if (start > end) {
            all_trees.add(null);
            return all_trees;
        }

        //尝试每个数字作为根节点
        for (int i = start; i <= end; i++) {
            // 递归构建左子树 得到所有可能的左子树
            List<TreeNode> left = generateTrees(start, i-1);
            // 递归构建右子树 得到所有可能的右子树
            List<TreeNode> right = generateTrees(i + 1, end);
            //左子树右子树两两组合
            for (TreeNode l: left) {
                for (TreeNode r: right) {
                    // i作为根节点
                    TreeNode curRoot = new TreeNode(i);
                    curRoot.left = l;
                    curRoot.right = r;
                    //加入到最终结果中
                    all_trees.add(curRoot);
                }
            }
        }
        return all_trees;
    }

    public static void main(String[] args) {
        Solution095GenerateTrees solu = new Solution095GenerateTrees();
        List<TreeNode> result = solu.generateTrees(3);
        for(TreeNode node: result) {
            System.out.print(node.val);
        }
    }
}
