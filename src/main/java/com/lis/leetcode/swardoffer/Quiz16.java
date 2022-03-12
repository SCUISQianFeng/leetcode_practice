package com.lis.leetcode.swardoffer;

import com.lis.leetcode.lc.base.common.ListNode;

/**
 * ClassName Quiz16
 * 输出反转后的链表
 * 题目描述： 输入一个链表， 反转链表后， 输出新链表的表头。
 * 思路： 定义两个指针， 反向输出
 * @author Lis on 2022/3/12
 **/
public class Quiz16 {


    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;

        while( curr != null) {
            ListNode tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }
        return pre;
    }
}
