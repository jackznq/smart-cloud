package com.smartcloud.common.utils.leetcode;

import java.util.*;

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
//        inOrderNonRecusion(one);
        int[][] metrix = {{}
//                {1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}
        };
//        System.out.println(searchMatrix(metrix, 13));
        postOrderNonRecur(one);
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
    public static void inOrderNonRecusion(TreeNode head) {
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
     *
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

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList();
        preorder1(root, res);
        return res;

    }

    public void preorder1(Node node, List<Integer> res) {
        if (node == null) return;
        res.add(node.val);
        List<Node> children = node.children;
        for (Node node1 : children) {
            preorder1(node1, res);
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /**
     * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
     * <p>
     * 每行中的整数从左到右按升序排列。
     * 每行的第一个整数大于前一行的最后一个整数。
     * 示例 1:
     * <p>
     * 输入:
     * matrix = [
     * [1,   3,  5,  7],
     * [10, 11, 16, 20],
     * [23, 30, 34, 50]
     * ]
     * target = 3
     * 输出: true
     * 示例 2:
     * <p>
     * 输入:
     * matrix = [
     * [1,   3,  5,  7],
     * [10, 11, 16, 20],
     * [23, 30, 34, 50]
     * ]
     * target = 13
     * 输出: false
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0) {
            return false;
        }
        boolean res = false;
        for (int i = 0; i < matrix.length; i++) {


            if (matrix[i].length == 0 || matrix[i][matrix[i].length - 1] < target) {
                continue;
            }
            //折半查找
            int length = matrix[i].length;
            int mid, low = 0, high = length;
            while (low <= high) {
                mid = (low + high) / 2;
                if (matrix[i][mid] == target) {
                    return true;
                } else if (matrix[i][mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

        }
        return res;
    }

    /**
     * 非递归方式后续遍历二叉树
     *
     * @param head
     */
    public static void postOrderNonRecur(TreeNode head) {
        if (head == null) return;
        Stack<TreeNode> s1 = new Stack();
        Stack<TreeNode> s2 = new Stack();
        s1.push(head);
        while (!s1.isEmpty()) {
            head = s1.pop();
            s2.push(head);
            if (head.left != null) {
                s1.push(head.left);
            }
            if (head.right != null) {
                s1.push(head.right);
            }
        }
        while (!s2.isEmpty()){
            System.out.println(s2.pop().val);
        }
    }
}
