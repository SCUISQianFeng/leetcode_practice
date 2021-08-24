package com.lis.leetcode.lc.base;

/**
 * common
 *
 * @author Lis
 * @version 1.0
 * @date 2021-8-24 18:21
 */
public class ListNode {
    public int val;
    public ListNode next;

    private ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
