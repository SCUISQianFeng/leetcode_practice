package com.lis.leetcode.swardoffer;

import java.util.Stack;

/**
 * ClassName Quiz22
 * 判断一个栈是否是另一个栈的弹出序列
 * 题目描述： 输入两个整数序列， 第一个序列表示栈的压入顺序， 请判断第二个序
 * 列是否为该栈的弹出顺序。 假设压入栈的所有数字均不相等。 例如序列 1,2,3,4,5
 * 是某栈的压入顺序， 序列 4， 5,3,2,1 是该压栈序列对应的一个弹出序列， 但
 * 4,3,5,1,2 就不可能是该压栈序列的弹出序列。 （注意： 这两个序列的长度是相等
 * 的）
 * 思路： 用栈来压入弹出元素， 相等则出栈。
 * 遍历压栈的每个元素，如果压入的元素和指针对应出栈的元素相同，则该元素出栈，并且指针后移，最后判断栈是否为空
 * @author Lis on 2022/3/13
 **/
public class Quiz22 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            if (!stack.isEmpty() && stack.peek() == popA[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.empty();
    }
}
