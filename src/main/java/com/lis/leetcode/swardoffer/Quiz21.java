package com.lis.leetcode.swardoffer;

import java.util.Stack;

/**
 * ClassName Quiz21
 * 包含 main 函数的栈
 * 题目描述： 定义栈的数据结构， 请在该类型中实现一个能够得到栈最小元素的 min
 * 函数。
 * 思路： 定义两个栈， 一个存放入的值。 另一个存最小值
 * @author Lis on 2022/3/13
 **/
public class Quiz21 {

    Stack<Integer> stack1;
    Stack<Integer> stack2;


    public void push(int node) {
        stack1.push(node);
        if (stack2.isEmpty()) {
            stack2.push(node);
        } else {
            if (stack2.peek() > node) {
                stack2.push(node);
            }
        }
    }

    public void pop() {
        if (stack1.pop() == stack2.peek()) {
            stack2.pop();
        }
    }

    public Integer top() {
        return stack1.peek();
    }

    public Integer min() {
        return stack2.peek();
    }
}
