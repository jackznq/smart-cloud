package com.smartcloud.common.utils.leetCode.map;

/**
 * @program: java-core-learning-example
 * @description: map
 * @author: znq
 * @create: 2020-01-02 17:17
 **/
public class LinkedListMap<K extends Comparable<? super K>, V> {


    public void add(K k, V v) {
        Node node = getNode(k);
        if (node == null) {
            dummyNode.next = new Node(k, v, dummyNode.next);
            size++;
        } else {
            node.v = v;
        }
    }

    public V remove(K k) {

        return null;
    }

    public boolean contains(K k) {
        return getNode(k) != null;
    }

    V get(K k) {
        Node node = getNode(k);
        return node == null ? null : node.v;
    }

    public void set(K k, V newValue) {
        Node node = getNode(k);
        if (node == null) {
            throw new IllegalArgumentException("");
        }
        node.v = newValue;
    }

    int getSize() {
        return size;
    }

    boolean isEmpty() {
        return size == 0;
    }

    private class Node {
        public K k;
        public V v;
        public Node next;

        public Node(K k, V v, Node next) {
            this.k = k;
            this.v = v;
            this.next = next;
        }

        public Node(K k, V v) {
            this(k, v, null);
        }

        public Node(K k) {
            this(k, null, null);
        }

        public Node() {
            this(null, null, null);
        }


        @Override
        public String toString() {
            return "Node{" +
                "k=" + k +
                ", v=" + v +
                '}';
        }
    }

    private int size;

    private Node dummyNode;


    public LinkedListMap() {
        this.size = 0;
        this.dummyNode = new Node();
    }

    private Node getNode(K k) {

        Node cur = dummyNode.next;
        while (cur != null) {
            if (cur.k.equals(k)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }


}
