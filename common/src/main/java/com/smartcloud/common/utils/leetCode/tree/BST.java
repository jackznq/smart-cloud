package com.smartcloud.common.utils.leetCode.tree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

/**
 * @program: java-core-learning-example
 * @description: 二分搜索树
 * @author: znq
 * @create: 2019-12-03 19:49
 **/
public class BST<E extends Comparable<? super E>> {

    private TreeNode root;

    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public BST(TreeNode root) {
        this.root = root;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addRecur(E e) {
        root = add(root, e);
    }

    private TreeNode add(TreeNode node, E e) {
        if (node == null) {
            size++;
            return new TreeNode(e);
        }

        if (node.e.compareTo(e) < 0) {
            node.right = add(node.right, e);
        } else {
            node.left = add(node.left, e);
        }
        return node;
    }


    public void addForeach(E e) {
        if (root == null) {
            root = new TreeNode(e);

        } else {
            TreeNode node = root;
            while (node != null) {

                if (node.e.compareTo(e) > 0) {
                    if (node.left == null) {
                        node.left = new TreeNode<>(e);
                        break;
                    } else {
                        node = node.left;
                    }
                } else if (node.e.compareTo(e) < 0) {
                    if (node.right == null) {
                        node.right = new TreeNode<>(e);
                        break;
                    } else {
                        node = node.right;
                    }
                } else {
                    break;
                }
            }
        }
        size++;
    }

    public void preOrderForeach() {//先序遍历
        //先序遍历
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        stack.push(cur);
        while (stack.size() > 0) {
            TreeNode pop = stack.pop();
            if (pop != null) {
                System.out.println(pop.e);
                if (pop.right != null) {
                    stack.push(pop.right);
                }
                if (pop.left != null) {
                    stack.push(pop.left);
                }
            }
        }

    }

    public void inOrderTraversal() {  //中序遍历
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || stack.size() > 0) {
            if (node != null) {
                stack.push(node);   //直接压栈
                node = node.left;
            } else {
                node = stack.pop(); //出栈并访问
                System.out.println(node.e);
                node = node.right;

            }
        }
    }

    /**
     * 优点:更快的找到元素
     * 采用队列进行广度遍历
     */
    public void levelOrder() {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            TreeNode node = queue.poll();
            System.out.println(node.e);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    /**
     * @param e
     */
    public void remove(E e) {
        TreeNode v = getTreeNode(e);
        if (v == null) {
            return;
        }
        root = removeNode(root, e);
    }


    private TreeNode removeNode(TreeNode node, E v) {
        if (node == null) return null;

        if (node.e.compareTo(v) > 0) {
            node = removeNode(node.right, v);
            return node;
        } else if (node.e.compareTo(v) < 0) {
            node = removeNode(node.left, v);
            return node;
        } else {
            //右子树
            if (node.right == null) {
                TreeNode left = node.left;
                size--;
                node.left = null;
                return left;
            }
            //左子树
            if (node.left == null) {
                TreeNode right = node.right;
                size--;
                node.right = null;
                return right;
            }

            //待删除节点左右子树不为空
            //找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
            //用这个节点顶替待删除节点的位置
            TreeNode successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;

        }
    }


    private TreeNode getTreeNode(E e) {
        if (Objects.isNull(e)) {
            return null;
        }
        TreeNode cur = root;
        while (cur != null) {
            int res = cur.e.compareTo(e);
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

    /**
     * 删除最小值，并且返回
     *
     * @return
     */
    public TreeNode removeMin() {
        TreeNode result = minimum();
        //删除该值
        root = removeMin(root);
        return result;
    }

    private TreeNode removeMin(TreeNode node) {
        if (node.left == null) {
            TreeNode right = node.right;
            size--;
            node.right = null;
            return right;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public TreeNode removeMax() {
        TreeNode result = maximum();
        //删除该值
        root = removeMax(root);
        return result;
    }

    private TreeNode removeMax(TreeNode node) {
        if (node.right == null) {
            TreeNode left = node.left;
            size--;
            node.left = null;
            return left;
        }
        node.right = removeMax(node.right);
        return node;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        generateString(root, 0, sb);
        return sb.toString();
    }

    private void generateString(TreeNode node, int depth, StringBuilder sb) {
        if (node == null) {
            sb.append(genetateDepthString(depth) + "\n");
            return;
        }

        sb.append(genetateDepthString(depth) + node.e + "\n");
        generateString(node.left, depth + 1, sb);
        generateString(node.right, depth + 1, sb);

    }

    private String genetateDepthString(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("--");
        }
        return sb.toString();
    }


    public TreeNode minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("");
        }
        return minimum(root);
    }

    private TreeNode minimum(TreeNode node) {
        if (node.left == null) {
            return node;
        }

        return minimum(node.left);

    }

    public TreeNode maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("");
        }
        return maximum(root);
    }

    private TreeNode maximum(TreeNode node) {
        if (node.right == null) {
            return node;
        }

        return maximum(node.right);

    }


    public static void main(String[] args) {
        BST bst = new BST();
        bst.addRecur(10);
        bst.addRecur(8);
        bst.addRecur(9);
        bst.addRecur(4);
        bst.addRecur(16);
        bst.addRecur(18);
        bst.addRecur(12);
        bst.inOrderTraversal();
    }

}
