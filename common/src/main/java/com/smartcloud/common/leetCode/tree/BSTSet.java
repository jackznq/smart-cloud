package com.smartcloud.common.leetCode.tree;

/**
 * @program: java-core-learning-example
 * @description: 自定义set
 * @author: znq
 * @create: 2019-12-30 09:05
 **/
public class BSTSet<E extends Comparable<E>> {

    private BST<E> bst;


    public BSTSet() {
        this.bst = new BST<>();
    }

    public void add(E e) {
        bst.addRecur(e);
    }


    public int getSize() {
        return bst.size();
    }


    public boolean isEmpty() {
        return bst.isEmpty();
    }

    public boolean contains() {
        return true;
//        return bst.
    }

    public void remvoe(E e) {
        bst.remove(e);
    }

}
