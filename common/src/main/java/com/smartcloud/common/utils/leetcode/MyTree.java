package com.smartcloud.common.utils.leetcode;

import java.util.Stack;

/**
 * 二叉树相关的算法
 */
public class MyTree {
    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        one.left = new TreeNode(2);
        one.right = new TreeNode(3);
        one.left.left = new TreeNode(4);
        one.left.right = new TreeNode(5);
        one.right.left = new TreeNode(6);
        one.right.right = new TreeNode(7);
        postOrderNonRecusion(one);
    }


    public static class TreeNode {
        private int val;


        private TreeNode left;

        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 二叉树中序遍历非递归
     * 用栈的方式解决
     */
    public static void postOrderNonRecusion(TreeNode head) {
        if (head == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = head;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                System.out.println(cur.val);
                cur = cur.right;
            }

        }

    }


    /**
     * 合并二叉树
     * @param t1
     * @param t2
     * @return
     */
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {


        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }

        TreeNode result = new TreeNode((t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val));
        result.left = mergeTrees(t1.left, t2.left);
        result.right = mergeTrees(t1.right, t2.right);
        return result;
    }
}
