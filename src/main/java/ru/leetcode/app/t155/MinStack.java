package ru.leetcode.app.t155;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class MinStack {
    /**
     * https://leetcode.com/problems/min-stack/
     */


    Stack<Integer> stack;
    Stack<Integer> min;
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (min.isEmpty()) {
            min.push(val);
        } else {
            min.push(Math.min(val, min.peek()));
        }
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}

