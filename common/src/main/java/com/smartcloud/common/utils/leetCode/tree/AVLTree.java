package com.smartcloud.common.utils.leetCode.tree;

import java.util.Objects;

/**
 * @program: java-core-learning-example
 * @description: avl
 * @author: znq
 * @create: 2020-02-26 16:21
 **/
public class AVLTree<K extends Comparable<? super K>, V> {


    private class Node {
        public K k;
        public V v;
        public Node right;
        public Node left;
        public int height;


        public Node(K e, V v) {
            this.k = e;
            this.v = v;
            this.left = null;
            this.right = null;
            height = 1;
        }


    }

    private Node root;

    private int size;

    public AVLTree() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    //记录节点的高度
    private int getHeight(Node node) {
        if (null == node) return 0;
        return node.height;
    }

    //获取平衡因子
    private int getBalanceFactor(Node node) {
        if (null == node) return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    public void add(K k, V v) {
        root = add(root, k, v);
    }

    private Node add(Node node, K k, V v) {
        if (node == null) {
            size++;
            return new Node(k, v);
        }

        if (node.k.compareTo(k) < 0) {
            node.right = add(node.right, k, v);
        } else {
            node.left = add(node.left, k, v);
        }
        node.height = 1 + Math.max(getHeight(node.right), getHeight(node.left));
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) >= 2) {
            System.out.println("不平衡");
        }
        //LL
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
            return rightRotate(node);
        }
        //RR
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
            return leftRotate(node);
        }
        //LR
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        //RL
        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node.left);
        }
        return node;
    }

    //左旋
    private Node leftRotate(Node y) {
        Node x = y.right;
        Node T3 = x.left;
        x.left = y;
        y.right = T3;
        y.height = Math.max(getHeight(y.right), getHeight(x.left)) + 1;
        x.height = Math.max(getHeight(x.right), getHeight(x.left)) + 1;
        return x;
    }

    //右旋
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T3 = x.right;
        x.right = y;
        y.left = T3;
        y.height = Math.max(getHeight(y.right), getHeight(x.left)) + 1;
        x.height = Math.max(getHeight(x.right), getHeight(x.left)) + 1;
        return x;
    }

    public V remove(K k) {
        Node v = getTreeNode(k);
        if (v == null) {
            return null;
        }
        root = removeNode(root, k);
        return v.v;
    }

    private Node getTreeNode(K e) {
        if (Objects.isNull(e)) {
            return null;
        }
        Node cur = root;
        while (cur != null) {
            int res = cur.k.compareTo(e);
            if (res < 0) {
                cur = cur.left;
            } else if (res > 0) {
                cur = cur.right;
            } else {
                return cur;
            }
        }
        return null;
    }

    private Node removeNode(Node node, K k) {
        if (node == null) return null;

        Node rerNode;
        if (node.k.compareTo(k) > 0) {
            node = removeNode(node.right, k);
            rerNode = node;
        } else if (node.k.compareTo(k) < 0) {
            node = removeNode(node.left, k);
            rerNode = node;
        } else {
            //右子树
            if (node.right == null) {
                Node left = node.left;
                size--;
                node.left = null;
                rerNode = left;
            } else if (node.left == null) {
                //左子树
                Node right = node.right;
                size--;
                node.right = null;
                rerNode = right;
            } else {

                //待删除节点左右子树不为空
                //找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
                //用这个节点顶替待删除节点的位置
                Node successor = minimum(node.right);
                successor.right = removeNode(node.right, successor.k);
                successor.left = node.left;
                node.left = node.right = null;
                rerNode = successor;
            }

        }

        if (rerNode == null) {
            return null;
        }

        rerNode.height = 1 + Math.max(getHeight(rerNode.right), getHeight(rerNode.left));
        int balanceFactor = getBalanceFactor(node);
        //LL
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
            return rightRotate(node);
        }
        //RR
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
            return leftRotate(node);
        }
        //LR
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        //RL
        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node.left);
        }
        return rerNode;

    }

    public Node minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("");
        }
        return minimum(root);
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }

        return minimum(node.left);

    }

    public Node maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("");
        }
        return maximum(root);
    }

    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }

        return maximum(node.right);

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
}
