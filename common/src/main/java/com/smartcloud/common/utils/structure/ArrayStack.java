package com.smartcloud.common.utils.structure;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;

/**
 * @program: smart.cloud
 * @description: arrayStack
 * @author: znq
 * @create: 2019-10-12 16:06
 **/
public class ArrayStack<E> implements Stack<E> {

    private ArrayList<E> arrayList;

    public ArrayStack(int capacity) {
        arrayList = new ArrayList<>(capacity);
    }

    public ArrayStack() {
        arrayList = new ArrayList<>();
    }

    @Override
    public void push(E o) {
        arrayList.add(o);
    }

    @Override
    public int getSize() {
        return arrayList.size();
    }

    @Override
    public boolean isEmpty() {
        return arrayList.isEmpty();
    }

    @Override
    public E pop() {
        return arrayList.remove(arrayList.size() - 1);
    }

    @Override
    public E peek() {
        return arrayList.get(arrayList.size() - 1);
    }

    @Override
    public String toString() {
        for (E e : arrayList) {
            System.out.println(e);
        }
        return "";
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new ArrayStack();
        System.out.println("push()");
        stack.push(1);
        stack.push(2);
        stack.push(23);
        stack.push(4);
        stack.push(10);
        stack.toString();
        System.out.println("pop()");
        stack.pop();
        stack.toString();
        System.out.println("peek()");
        System.out.println(stack.peek());
    }
}

