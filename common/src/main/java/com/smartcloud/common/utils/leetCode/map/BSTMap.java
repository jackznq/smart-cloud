package com.smartcloud.common.utils.leetCode.map;

/**
 * @program: java-core-learning-example
 * @description: map
 * @author: znq
 * @create: 2020-01-02 17:17
 **/
public class BSTMap<K extends Comparable<? super K>, V> {


    public void add(K k, V v) {
        root = add(root, k, v);
    }

    public Node add(Node node, K k, V v) {
        if (node == null) {
            size++;
            return new Node(k, v);
        }

        if (node.k.compareTo(k) < 0) {
            node.right = add(node.right, k, v);
        } else if (node.k.compareTo(k) > 0) {
            node.left = add(node.left, k, v);
        } else {
            node.v = v;
        }
        return node;
    }

    public V remove(K k) {

        Node node = getNode(root, k);
        if (node == null) {
            return null;
        }
        root = removeNode(node, k);
        return node.v;
    }

    private Node removeNode(Node node, K v) {
        if (node == null) return null;

        if (node.k.compareTo(v) > 0) {
            node = removeNode(node.right, v);
            return node;
        } else if (node.k.compareTo(v) < 0) {
            node = removeNode(node.left, v);
            return node;
        } else {
            //右子树
            if (node.right == null) {
                Node left = node.left;
                size--;
                node.left = null;
                return left;
            }
            //左子树
            if (node.left == null) {
                Node right = node.right;
                size--;
                node.right = null;
                return right;
            }

            //待删除节点左右子树不为空
            //找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
            //用这个节点顶替待删除节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;

        }
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }

        return minimum(node.left);

    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node right = node.right;
            size--;
            node.right = null;
            return right;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public boolean contains(K k) {
        return getNode(root, k) != null;
    }

    V get(K k) {
        Node node = getNode(root, k);
        return node == null ? null : node.v;
    }

    public void set(K k, V newValue) {
        Node node = getNode(root, k);
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
        public Node left, right;

        public Node(K k, V v) {
            this.k = k;
            this.v = v;
            this.left = null;
            this.right = null;
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

    private Node root;


    public BSTMap() {
        this.size = 0;
        this.root = null;
    }

    private Node getNode(Node node, K k) {

        if (node == null) return null;
        if (k.compareTo(node.k) == 0) {
            return node;

        } else if (k.compareTo(node.k) < 0) {
            return getNode(node.left, k);
        } else {
            return getNode(node.right, k);
        }

    }


}
