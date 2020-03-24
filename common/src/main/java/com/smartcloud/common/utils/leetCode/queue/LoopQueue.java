package com.smartcloud.common.utils.leetCode.queue;

import lombok.ToString;
import org.omg.CORBA.Object;

/**
 * @program: java-core-learning-example
 * @description: 循环队列：解决普通队列出队时空间浪费
 * @author: znq
 * @create: 2019-10-24 07:05
 **/
@ToString
public class LoopQueue<E extends Comparable<? super E>> implements Queue<E> {

    private E[] data;

    //front == tail  queue is empty
    //(tail+1)%c=front queue is full
    //需要浪费一个空间 capacity-1
    private int front, tail;

    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = tail = size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean add(E e) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
        return true;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }


    @Override
    public E poll() {
        if (isEmpty()) {
            throw new IllegalStateException("queue is empty");
        }
        E e = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return e;
    }

    @Override
    public E peek() {
        if (isEmpty()) throw new IllegalStateException("queue is empty");
        return data[front];
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public int size() {
        return size;
    }

}
