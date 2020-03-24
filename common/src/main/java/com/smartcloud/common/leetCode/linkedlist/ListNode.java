package com.smartcloud.common.leetCode.linkedlist;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ListNode<E extends Comparable<? super E>> {
    public E e;
    @Setter
    @Getter
    public ListNode<E> next;

    public ListNode(E x) {
        e = x;
    }

    public ListNode(E e, ListNode next) {
        this.e = e;
        this.next = next;
    }

    public ListNode(E arr[]) {
        if (arr.length == 0 || arr == null) {
            throw new IllegalArgumentException("empty param");
        }
        this.e = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            sb.append(cur.e);
            if (cur.next != null) {
                sb.append("->");
            }
            cur = cur.next;

        }
        return sb.toString();
    }


}
