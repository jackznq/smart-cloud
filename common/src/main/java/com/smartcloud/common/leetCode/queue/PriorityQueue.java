package com.smartcloud.common.leetCode.queue;


import com.smartcloud.common.leetCode.heap.MaxHeap;

/**
 * @program: java-core-learning-example
 * @description: 优先队列
 * @author: znq
 * @create: 2019-10-24 07:05
 **/
public class PriorityQueue<E extends Comparable<? super E>> implements Queue<E> {

    private MaxHeap maxHeap;

    public PriorityQueue(MaxHeap maxHeap) {
        this.maxHeap = maxHeap;
    }

    public PriorityQueue() {
        maxHeap = new MaxHeap();
    }

    @Override
    public boolean add(E e) {
        maxHeap.add(e);
        return true;
    }

    @Override
    public E poll() {
        return (E) maxHeap.pop();
    }

    @Override
    public E peek() {
        return (E) maxHeap.peak();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    @Override
    public int size() {
        return maxHeap.getSize();
    }

    @Override
    public int getCapacity() {
        return 0;
    }
}
