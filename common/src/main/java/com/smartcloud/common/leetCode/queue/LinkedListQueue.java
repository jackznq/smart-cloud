package com.smartcloud.common.leetCode.queue;

import lombok.ToString;

/**
 * @program: java-core-learning-example
 * @description: 链表队列
 * @author: znq
 * @create: 2019-10-24 07:05
 **/
@ToString
public class LinkedListQueue<E extends Comparable<E>> implements Queue<E> {

    @ToString
    private class Node<E> {

        public E e;

        public Node next;

        Node() {
            this(null, null);
        }

        Node(E e) {
            this(e, null);
        }

        Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }
    }

    private Node head, tail;

    private int size;

    public LinkedListQueue() {
        head = tail = null;
        size = 0;
    }

    @Override
    public boolean add(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;

        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            throw new IllegalArgumentException();
        }
        Node retNode = this.head;
        head = retNode.next;
        retNode.next = null;
        if (head == null) tail = null;
        size--;
        return (E) retNode.e;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new IllegalArgumentException();
        }
        return (E) head.e;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int getCapacity() {
        return 0;
    }

}
