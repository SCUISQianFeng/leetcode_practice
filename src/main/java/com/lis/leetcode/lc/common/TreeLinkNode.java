package com.lis.leetcode.lc.common;

/**
 * ClassName TreeLinkNode
 *
 * @author Lis on 2022/3/13
 **/
public class TreeLinkNode {
    public int val;
    public TreeLinkNode left;
    public TreeLinkNode right;
    public TreeLinkNode next;


    public TreeLinkNode() {}

    public TreeLinkNode(int val) {
        this.val = val;
    }

    public TreeLinkNode(int val, TreeLinkNode left, TreeLinkNode right, TreeLinkNode next ) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}
