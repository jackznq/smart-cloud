package com.smartcloud.common.leetCode.queue;

/**
 * @program: java-core-learning-example
 * @description: 自己实现的队列
 * @author: znq
 * @create: 2019-10-20 22:02
 **/
public interface Queue<E extends Comparable<? super E>> {


    /**
     * 添加一个元素
     *
     * @param e
     * @return
     */
    boolean add(E e);


    /**
     * 出队
     *
     * @return
     */
    E poll();


    /**
     * 查看队首的元素
     *
     * @return
     */
    E peek();

    /**
     * 判断一个队列是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 队列大小
     *
     * @return
     */
    int size();

     int getCapacity();
}
