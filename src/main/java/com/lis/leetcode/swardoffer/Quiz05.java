package com.lis.leetcode.swardoffer;

import com.lis.leetcode.lc.base.common.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 表
 * 题目描述： 输入一个链表， 从尾到头打印链表每个节点的值。
 * 思路： 借助栈实现， 或使用递归的方法。
 */
public class Quiz05 {

    /**
     * 解法一： 借用栈
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while(listNode != null) {
            stack.push(listNode.getVal());
        }
        while(!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    /**
     * 递归
     * @param headNode
     * @return
     */
    public static ArrayList<Integer> printListReverse2(ListNode headNode) {
        ArrayList<Integer> list = new ArrayList<>();

        while (headNode != null) {
            if (headNode.next != null) {
                list = printListReverse2(headNode.next);
            }
        }
        return list;
    }

}
