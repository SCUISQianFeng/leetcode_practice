package com.lis.leetcode.swardoffer;

import com.lis.leetcode.lc.common.RandomListNode;

/**
 * ClassName Quiz26
 * 复杂链表的复制
 * 题目描述： 输入一个复杂链表（每个节点中有节点值， 以及两个指针， 一个指向
 * 下一个节点， 另一个特殊指针指向任意一个节点） ， 返回结果为复制后复杂链表的
 * head。 （注意， 输出结果中请不要返回参数中的节点引用， 否则判题程序会直接
 * 返回空）
 * 思路： 先复制链表的 next 节点， 将复制后的节点接在原节点后， 然后复制其它的
 * 节点， 最后取偶数位置的节点（复制后的节点） 。
 * 第一步仍然是根据原始链表的每个结点N创建对应的N'。（把N'链接在N的后面）
 * 第二步设置复制出来的结点的Sibling。（把N'的Sibling指向N的Sibling）
 * 第三步把这个长链表拆分成两个链表：把奇数位置的结点用Next链接起来就是原始链表，偶数数值的则是复制链表。
 * @author Lis on 2022/3/13
 **/
public class Quiz26 {
    public RandomListNode Clone2(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        // 复制当前节点并将该节点作为复制出来的链表的头节点
        RandomListNode head = new RandomListNode(pHead.data);
        RandomListNode temp = head;

        while (pHead != null) {
            //  将复制的节点接的next和sibling接在复制出来的节点后
            temp.next = new RandomListNode(pHead.next.data);
            if (pHead.sibling != null) {
                temp.sibling = new RandomListNode(pHead.sibling.data);
            }
            pHead = head.next;
            temp = temp.next;
        }
        return head;
    }
}
