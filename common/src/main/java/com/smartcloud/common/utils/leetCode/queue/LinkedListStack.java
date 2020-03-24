package com.smartcloud.common.utils.leetCode.queue;

import org.javacore.leetCode.linkedlist.LinkedList;

/**
 * 链表实现栈
 *
 * @param <E>
 */
public class LinkedListStack<E extends Comparable<? super E>> {

    private LinkedList<E> list;

    public LinkedListStack() {
        list = new LinkedList();
    }

    public E peek() {
        return list.getFirst();
    }

    public void push(E obj) {

        list.addFirst(obj);
    }

    public E pop() {

        return list.removeFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
