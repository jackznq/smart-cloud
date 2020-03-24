package com.smartcloud.common.utils.leetCode.tree;

import lombok.Data;
import lombok.ToString;

/**
 * 树节点构建，
 * Created by ddfhznq on 2017/11/22.
 */
@Data
@ToString
public class TreeNode<E extends Comparable<? super E> >{

    public E e;
    public TreeNode right;
    public TreeNode left;

    public TreeNode(int val) {
        this.left = null;
        this.right = null;
    }

    public TreeNode(E e) {
        this.e = e;
        this.left = null;
        this.right = null;
    }

    public TreeNode() {
        this.left = null;
        this.right = null;
        this.e = null;
    }
}
