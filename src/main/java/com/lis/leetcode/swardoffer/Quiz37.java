package com.lis.leetcode.swardoffer;

import com.lis.leetcode.lc.base.common.ListNode;

/**
 * ClassName Quiz37
 * 两个链表的第一个公共节点
 * 题目描述： 输入两个链表， 找出它们的第一个公共结点。
 * 思路： 先求出链表长度， 然后长的链表先走多出的几步， 然后两个链表同时向下
 * 走去寻找相同的节点， 代码量少的方法需要将两个链表遍历两次， 然后从头开始相
 * 同的节点
 * @author Lis on 2022/3/13
 **/
public class Quiz37 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2){
            p1 = (p1 != null ? p1.next : pHead2);
            p2 = (p2 != null ? p2.next : pHead1);
        }
        return p1;
    }
}
