package com.lis.leetcode.swardoffer;

import com.lis.leetcode.lc.common.ListNode;

/**
 * ClassName Quiz56
 * 链表中环的入口节点
 * 题目描述： 一个链表中包含环， 请找出该链表的环的入口结点。
 * 思路： 定义快慢两个指针， 相遇后（环中相汇点） 将快指针指向 pHead 然后一起
 * 走， 每次往后挪一位， 相遇的节点即为所求。 详细分析： 相遇即 p1==p2 时， p251
 * 所经过节点数为 2x,p1 所经过节点数为 x,设环中有 n 个节点,p2 比 p1 多走一圈有
 * 2x=n+x; n=x;可以看出 p1 实际走了一个环的步数， 再让 p2 指向链表头部， p1 位
 * 置不变， p1,p2 每次走一步直到 p1==p2; 此时 p1 指向环的入口。
 * 凡是求相会点的都可以用快慢指针的方式，fast先走多步，相会走再一起走，要是还能相会，就说明找到相会点了
 *
 * @author Lis on 2022/3/13
 **/
public class Quiz56 {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return null;
        ListNode slow = pHead;
        ListNode fast = pHead;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = pHead;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                if (fast == slow)
                    return slow;
            }
        }
        return null;
    }
}
