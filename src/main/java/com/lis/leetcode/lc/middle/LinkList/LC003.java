package com.lis.leetcode.lc.middle.LinkList;

import com.lis.leetcode.lc.base.common.ListNode;

/**
 * LC003
 *
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * @author Lis
 * @version 1.0
 * @date 2022-3-3 17:17
 */
public class LC003 {
	/**
	 * 两种方法，一种是先计算两个链表的长度，要是一样长，就同时走，要是不一样长，就让长的先走
	 * 另一种就是交替前进，A走完就从B开始的位置开始走，B走完就从A开始的位置走，形成一个环，如果有交点，就一直会相遇
	 * @param headA
	 * @param headB
	 * @return
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode tmpA = headA;
		ListNode tmpB = headB;
		while(tmpA != tmpB) {
			// 至少会交替一轮
			tmpA = tmpA == null ? headB: tmpA.next;
			tmpB = tmpB == null ? headA: tmpB.next;
		}
		return tmpA;
	}
	public ListNode getIntersectionNodeWithLength(ListNode headA, ListNode headB) {
		int lengthA = listNodeLenght(headA);
		int lengthB = listNodeLenght(headB);
		while(lengthA != lengthB) {
			// 长的先走
			if (lengthA > lengthB) {
				headA = headA.next;
				lengthA--;
			} else {
				headB = headB.next;
				lengthB--;
			}
		}
		while(headA != headB) {
			// 如果不相交，则一直走到末尾
			headA = headA.next;
			headB = headB.next;
		}
		return headA;
	}

	private int listNodeLenght(ListNode head) {
		int length = 0;
		if (head != null) {
			length++;
			head = head.next;
		}
		return length;
	}
}
