package com.smartcloud.common.utils.structure;

/**
 * @program: smart.cloud
 * @description: stack
 * @author: znq
 * @create: 2019-10-12 16:02
 **/
public interface Stack<E> {

    void push(E e);

    int getSize();

    boolean isEmpty();

    E pop();

    E peek();

}
