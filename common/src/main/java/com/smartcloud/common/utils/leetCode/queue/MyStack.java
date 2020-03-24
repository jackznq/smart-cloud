package com.smartcloud.common.utils.leetCode.queue;

import java.util.ArrayDeque;
import java.util.Queue;

class MyStack {

    private Queue<Integer> input;

    private Queue<Integer> output;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        input = new ArrayDeque();
        output = new ArrayDeque();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        input.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        int val = 0;
        if (!input.isEmpty()) {
            while (!input.isEmpty()) {
                if (input.size() > 1) {
                    output.add(input.poll());
                } else {
                    val = input.poll();
                    while (!output.isEmpty()) {
                        input.add(output.poll());
                    }
                    return val;
                }
            }
        }
        return val;
    }

    /**
     * Get the top element.
     */
    public int top() {
        if (!input.isEmpty()) {
            while (!input.isEmpty()) {
                if (input.size() > 1) {
                    output.add(input.poll());
                } else {
                    return input.peek();
                }
            }
        }
        return 0;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        if (!input.isEmpty() || !output.isEmpty()) {
            return false;
        }

        return true;
    }

}
