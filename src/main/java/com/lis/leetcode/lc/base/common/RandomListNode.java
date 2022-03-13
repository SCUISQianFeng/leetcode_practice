package com.lis.leetcode.lc.base.common;

/**
 * ClassName RandomListNode
 *
 * @author Lis on 2022/3/13
 **/
public class RandomListNode {

    public int data;
    public RandomListNode next;
    public RandomListNode sibling;

    public RandomListNode(int data) {
        this.data = data;
    }

    public RandomListNode(int data, RandomListNode next, RandomListNode sibling) {
        this.data = data;
        this.next = next;
        this.sibling = sibling;
    }
}