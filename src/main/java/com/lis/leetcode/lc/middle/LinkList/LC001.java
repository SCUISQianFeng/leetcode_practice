package com.lis.leetcode.lc.middle.LinkList;

import com.lis.leetcode.lc.common.ListNode;

/**
 * LC001
 *
 * <p>给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * <p>请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * <p>你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 输入：l1 = [2,4,3], l2 = [5,6,4] 输出：[7,0,8] 解释：342 + 465 = 807. 示例
 * 2：
 *
 * <p>输入：l1 = [0], l2 = [0] 输出：[0] 示例 3：
 *
 * <p>输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9] 输出：[8,9,9,9,0,0,0,1]
 *
 * <p>作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvw73v/ 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author Lis
 * @version 1.0
 * @date 2022-3-3 15:19
 */
public class LC001 {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int flag = 0;
		ListNode preNode = new ListNode(0);
		ListNode resNode = preNode;
		while(l1 != null && l2 != null) {
			// 当前位的值
			int currentVal = l1.val + l2.val + flag;
			preNode.next = new ListNode(currentVal % 10);
			// 进位数
			flag = currentVal / 10;
			l1 = l1.next;
			l2 = l2.next;
			preNode = preNode.next;
		}
		while(l1 != null) {
			// l1列表还有值
			int currentVal = l1.val + flag;
			preNode.next = new ListNode(currentVal % 10);
			flag = currentVal / 10;
			l1  = l1.next;
			preNode = preNode.next;

		}
		while(l2 != null) {
			// l1列表还有值
			int currentVal = l2.val + flag;
			preNode.next = new ListNode(currentVal % 10);
			flag = currentVal / 10;
			l2  = l2.next;
			preNode = preNode.next;
		}
		if(flag != 0) {
			// 还需要再进一位
			preNode.next = new ListNode(1);
		}
		return resNode.next;
	}

  public static void main(String[] args) {
	  ListNode node1 = new ListNode(0);
	  ListNode node2 = new ListNode(0);

	  ListNode newNode = LC001.addTwoNumbers(node1, node2);
	  while(newNode != null) {
        System.out.println(newNode.val);
        newNode = newNode.next;
	  }
  }
}
