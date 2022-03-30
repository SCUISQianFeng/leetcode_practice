package com.lis.leetcode.lc.base.design;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lis
 * @version 1.0
 * @date 2022-3-30
 **/
public class MinStack {

    private List<Integer> minStack;
    private int minValue = Integer.MAX_VALUE;

    public MinStack() {
        minStack = new LinkedList<>();
    }

    public void push(int val) {
        minStack.add(val);
        this.reSort();
    }

    public void pop() {
        minStack.remove(minStack.size() - 1);
        this.reSort();
    }

    public int top() {
        return  minStack.get(minStack.size() - 1);
    }

    public int getMin() {
        return minValue;
    }

    private void reSort() {
        // 需要将minStack中的所有元素进行排序，重置minValue
        for(int value: minStack) {
            if (value < minValue);
            minValue = value;
        }


    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());   // --> 返回 -3.
        minStack.pop();
        System.out.println(minStack.top()); //--> 返回 0.
        System.out.println(minStack.getMin()); // --> 返回 -2.
    }
}
