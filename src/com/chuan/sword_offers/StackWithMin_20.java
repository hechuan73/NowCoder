package com.chuan.sword_offers;

import java.util.Stack;

/**
 * @author hechuan
 */
public class StackWithMin_20 {
    private int min = Integer.MAX_VALUE;
    private Stack<Integer> stack = new Stack<>();
    public void push(int node) {
        if (node <= min) {
            stack.push(min);
            min = node;
        }

        stack.push(node);
    }

    public void pop() {
        if (stack.pop() == min) { min = stack.pop(); }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min;
    }
}
