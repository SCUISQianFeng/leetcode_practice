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
        if (val < minValue) {
            minValue = val;
        }
        minStack.add(val);
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
        if (minStack.size() != 0) {
            minValue = minStack.get(0);
            // 需要将minStack中的所有元素进行排序，重置minValue
            for(int value: minStack) {
                if (value < minValue) {
                    minValue = value;
                }
            }
        } else {
            minValue = Integer.MAX_VALUE;
        }

    }

    public static void main(String[] args) {
        /**
         * ["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
         * [[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]
         * MinStack
         * push  2147483646
         * push  2147483646
         * push  2147483646
         * top
         * pop
         * getMin
         * pop
         * getMin
         * pop
         * push 2147483647
         * top
         * getMin
         * push -2147483648
         * top
         * getMin
         * pop
         * getMin
         */
        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        System.out.println(minStack.top());   // --> 返回 -3.
        minStack.pop();
        System.out.println(minStack.getMin()); // --> 返回 -2.
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.push(2147483647);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.push(-2147483648);
        System.out.println(minStack.top()); //--> 返回 0.
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
