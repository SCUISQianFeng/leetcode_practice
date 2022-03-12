package com.lis.leetcode.swardoffer;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * 题目描述： 用两个栈来实现一个队列， 完成队列的 Push 和 Pop 操作。 队列中的
 * 元素为 int 类型。
 * 思路： 一个栈压入元素， 而另一个栈作为缓冲， 将栈 1 的元素出栈后压入栈 2
 * 中。 也可以将栈 1 中的最后一个元素直接出栈， 而不用压入栈 2 中再出栈。
 * @author lis
 * @version 1.0
 * @date 2022-3-12
 **/
public class Quiz07 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;


    public void push(int node) {
        stack1.push(node);
    }
    public int pop() {
        if(stack1.empty() || stack2.empty()) {
            throw new RuntimeException("无法获取有效的值");
        }
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
