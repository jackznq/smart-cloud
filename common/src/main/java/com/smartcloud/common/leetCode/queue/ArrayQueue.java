package com.smartcloud.common.leetCode.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: java-core-learning-example
 * @description: 数组队列
 * @author: znq
 * @create: 2019-10-24 07:05
 **/
public class ArrayQueue<E extends Comparable<? super E>> implements Queue<E> {

    private List<E> list;

    private int front;

    private int tail;

    public ArrayQueue(int capacity) {
        list = new ArrayList(capacity);
        this.front = this.tail = 0;
    }

    public ArrayQueue() {
        list = new ArrayList(10);
        this.front = this.tail = 0;
    }


    @Override
    public boolean add(E e) {
        list.add(e);
        tail++;
        return true;
    }

    @Override
    public E poll() {
        if (front == tail) {
            throw new IllegalStateException("queue is empty");
        }
        E e = list.remove(front);
        front++;
        return e;
    }

    @Override
    public E peek() {
        return list.get(front);
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public int getCapacity() {
        return 0;
    }

}
