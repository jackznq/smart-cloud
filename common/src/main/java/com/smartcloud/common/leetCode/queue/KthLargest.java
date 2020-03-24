package com.smartcloud.common.leetCode.queue;


import java.util.PriorityQueue;

/**
 * Design a class to find the kth largest element in a stream.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream.
 * For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.
 */
class KthLargest {

    private PriorityQueue<Integer> priorityQueue;

    private int k;

    public KthLargest(int k, int[] nums) {
        if (nums == null) {
            return;
        }
        this.k = k;
        priorityQueue = new PriorityQueue<>(k);
        for (int n : nums) {
            add(n);
        }
    }

    public int add(int val) {
        //如果队列里面的值还没有满,则直接把值翻入
        if (k > priorityQueue.size()) {
            priorityQueue.add(val);
            return priorityQueue.peek();
        }
        //如果队列满了,则继续入队列的时候需要与队列中的值进行比较
        if (k == priorityQueue.size()) {
            Integer peek = priorityQueue.peek();
            //如果进来的值比队列中的最小值小，直接去队列中的最小值，否值，去掉队列中的最小值，
            // 插入val值，这时候队列会重新排序，取出最小值即可
            if (peek >= val) {
                return peek;
            }
            if (peek < val) {
                priorityQueue.poll();
                priorityQueue.add(val);
                return priorityQueue.peek();
            }
        }

        return 0;
    }

}
