package com.lis.leetcode.swardoffer;

import com.lis.leetcode.lc.common.ListNode;

/**
 * ClassName Quiz13
 *
 * O(1)时间删除链表节点
 * 题目描述： 给定单向链表的头指针和一个节点指针， 在 O(1)时间复杂度内删除该
 * 节点。
 * 思路： 将要删除节点的下一个节点的值赋给要删除的节点， 然后指向下下一个节
 * 点
 * @author Lis on 2022/3/12
 **/
public class Quiz13 {
    public void deleteNode(ListNode head, ListNode deListNode) {
        if (deListNode == null || head == null) {
            return;
        }
        if (head == deListNode) {
            // 将head置为null
            head = null;
        } else {
            // 若删除的是尾结点，往后移一位 （难点就在在于能否考虑到删除的尾结点）
            if (deListNode.next == null) {
                ListNode pointListNode = head;
                while (pointListNode.next.next != null) {
                    pointListNode = pointListNode.next;
                }
                pointListNode.next = null;
            } else {
                deListNode.val = deListNode.next.val;
                deListNode.next = deListNode.next.next;
            }
        }
    }
}
