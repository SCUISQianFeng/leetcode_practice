package com.lis.leetcode.swardoffer;

import com.lis.leetcode.lc.base.common.ListNode;

/**
 * ClassName Quiz17
 * 合并两个有序链表
 * 题目描述： 输入两个单调递增的链表， 输出两个链表合成后的链表， 当然我们需
 * 要合成后的链表满足单调不减规则。
 * 思路： 递归与非递归求解， 小数放在前面。
 * @author Lis on 2022/3/12
 **/
public class Quiz17 {
    /**
     * 解法一： 递归， 时间复杂度： O(m+n)， 空间复杂度： O(m+n)
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode preHead = new ListNode(-1);
        ListNode pre = preHead;

        while (list1 != null && list2 == null) {
            if (list1.val < list2.val) {
                pre.next = list1;
                list1 = list1.next;
            } else {
                pre.next = list2;
                list2 = list2.next;
            }
            // 指针后移
            pre = pre.next;
        }
        pre.next = list1 == null ? list2 : list1;
        return preHead.next;
    }
}
