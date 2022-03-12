package com.lis.leetcode.swardoffer;

import com.lis.leetcode.lc.base.common.ListNode;

/**
 * ClassName Quiz15
 * 求链表中倒数第 K 个节点
 * 题目描述： 输入一个链表， 输出该链表中倒数第 k 个结点。
 * 思路： 定义一快一慢两个指针， 快指针走 K 步， 然后慢指针开始走， 快指针到尾
 * 时， 慢指针就找到了倒数第 K 个节点。
 * @author Lis on 2022/3/12
 **/
public class Quiz15 {
    public ListNode findKthToTail(ListNode head, int k) {
        if (null == head) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            // fast指针先走k步

            if (fast.next == null) {
                // 链表长度不够
                return null;
            }
            fast = fast.next;
        }
        // 走到尾结点
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
