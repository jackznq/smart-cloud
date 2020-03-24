package com.smartcloud.common.leetCode.queue;

import java.util.Stack;

/**
 * Implement the following operations of a queue using stacks.
 * <p>
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 */
class MyQueue {

    /**
     * ["MyQueue","push","push","peek","pop","empty"]
     * [[],[1],[2],[],[],[]]
     */
    private Stack<Integer> pop;

    private Stack<Integer> push;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        pop = new Stack();
        push = new Stack();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        push.push(x);

    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (pop.isEmpty()) {
            if (!push.isEmpty()) {
                while (!push.isEmpty()) {
                    pop.push(push.pop());
                }
                return pop.pop();
            } else {
                empty();
            }
        }
        return pop.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (pop.isEmpty()) {
            if (!push.isEmpty()) {
                while (!push.isEmpty()) {
                    pop.push(push.pop());
                }
                return pop.peek();
            } else {
                empty();
            }
        }
        return pop.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        if (pop.isEmpty()) {
            if (!push.isEmpty()) {
                while (!push.isEmpty()) {
                    pop.push(push.pop());
                }
                return false;
            } else {
                return true;
            }
        }
        return false;
    }


}
