package com.smartcloud.common.leetCode.linkedlist;


/**
 * 关于链表的18个问题 @see http://cslibrary.stanford.edu/105/LinkedListProblems.pdf
 *
 * @program: java-core-learning-example
 * @description: 自定义链表实现
 * @author: znq
 * @create: 2019-10-27 13:41
 **/
public class LinkedList<E extends Comparable<? super E>> {


    private ListNode<E> dummyHead;

    private int size;

    public LinkedList(ListNode head) {
        this.dummyHead = head;
    }

    public LinkedList() {
        dummyHead = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void add(int index, E e) {
        //check index
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed");
        }
        //找到要插入的前一个节点
        ListNode pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = new ListNode(e, pre.next);
        size++;

    }

    public void addLast(E e) {
        this.add(size, e);
    }

    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("get faild");
        }
        ListNode cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return (E) cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("get faild");
        }
        ListNode pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        ListNode delNode = pre.next;
        pre.next = delNode.next;
        delNode.next = null;
        size--;
        return (E) delNode;
    }

    public E removeFirst() {
        return this.remove(0);
    }

    public E removeLast() {
        return this.remove(size - 1);
    }

    public boolean contains(E e) {
        ListNode cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public void clear() {
        ListNode cur = dummyHead.next;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
    }

    @Override
    public String toString() {
        return dummyHead.toString();
    }

}
