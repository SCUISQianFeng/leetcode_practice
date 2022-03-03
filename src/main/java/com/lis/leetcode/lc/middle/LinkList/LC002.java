package com.lis.leetcode.lc.middle.LinkList;

import com.lis.leetcode.lc.base.common.ListNode;

/**
 * LC002
 *
 * <p>给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
 *
 * <p>第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。
 *
 * <p>请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
 *
 * <p>你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。
 * 输入: head = [1,2,3,4,5] 输出: [1,3,5,2,4]
 * 输入: head = [2,1,3,5,6,4,7] 输出: [2,3,6,7,1,5,4]
 *
 * <p>作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvdwtj/ 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author Lis
 * @version 1.0
 * @date 2022-3-3 16:06
 */
public class LC002 {
	// 两个指针， 一个指针始终指向第一个偶数位，一个指针始终下一个
	public static ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode oddHead = head;
		ListNode curOddNode = oddHead;
		ListNode evenHead = head.next;
		ListNode curEvenNode = evenHead;
		while(curEvenNode != null && curEvenNode.next != null) {
			// 奇数指针连在一起
			curOddNode.next = curOddNode.next.next;
			// 偶数指针连在一起
			curEvenNode.next = curEvenNode.next.next;
			// 奇偶指针后移 这里的curOddNode.next已经指向下一个奇数位了
			curOddNode = curOddNode.next;
			curEvenNode = curEvenNode.next;
		}
		curOddNode.next = evenHead;
		return oddHead;
	}

  public static void main(String[] args) {
	  //
	  ListNode node1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
	  ListNode resNode = LC002.oddEvenList(node1);
	  while(resNode != null) {
	      System.out.println(resNode.val);
	      resNode = resNode.next;
	  }
  }
}
