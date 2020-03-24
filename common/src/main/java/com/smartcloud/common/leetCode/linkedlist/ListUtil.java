package com.smartcloud.common.leetCode.linkedlist;


import java.util.ArrayList;
import java.util.List;

/**
 * 关于链表的18个问题 @see http://cslibrary.stanford.edu/105/LinkedListProblems.pdf
 *
 * @program: java-core-learning-example
 * @description: list utils
 * @author: znq
 * @create: 2019-11-22 22:40
 **/
public class ListUtil {

    /**
     * 有序的链表中插入一个元素
     *
     * @param listNode
     * @param e
     * @param <E>
     */
    public static <E extends Comparable<? super E>> ListNode sortedInsert(ListNode listNode, E e) {
        sorted(listNode);
        if (listNode.next.e.compareTo(e) > 0) {
            ListNode head = new ListNode(e);
            head.next = listNode;
            return head;
        }
        ListNode cur = listNode;
        ListNode pre = listNode;
        while (cur != null) {
            if (cur.e.compareTo(e) > 0) {
                ListNode next = pre.next;
                ListNode newNode = new ListNode(e);
                pre.next = newNode;
                newNode.next = next;
                break;
            }
            if (cur.next == null) {
                ListNode newNode = new ListNode(e);
                cur.next = newNode;
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        return listNode;
    }

    /**
     * 链表排序
     *
     * @param head
     * @param <E>
     */
    public static <E extends Comparable<? super E>> void sorted(ListNode head) {
        if (head == null) return;
        ListNode<E> cur = head;
        E temp;
        while (cur != null) {
            ListNode<E> next = cur.next;
            while (next != null) {
                if (next.e.compareTo(cur.e) < 0) {
                    temp = next.e;
                    next.e = cur.e;
                    cur.e = temp;
                }
                next = next.next;
            }
            cur = cur.next;
        }
    }

    public static ListNode append(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode cur = l1;
        while (cur != null) {
            if (cur.next == null) {
                break;
            }
            cur = cur.next;
        }
        cur.next = l2;
        return l1;
    }


    /**
     * @param sou
     * @param des
     */
    public static ListNode[] moveNode(ListNode des, ListNode sou) {
        ListNode newNode = sou;
        ListNode[] result = new ListNode[2];
        if (newNode == null) {
            return result;
        }
        sou = sou.next;
        result[0] = sou;
        newNode.next = des;
        result[1] = newNode;
        return result;
    }

    /**
     * 13
     *
     * @param listNode1
     * @param listNode2
     * @return
     */
    public static ListNode shuffleMerge(ListNode listNode1, ListNode listNode2) {
        if (listNode1 == null) return listNode2;
        if (listNode2 == null) return listNode1;
        ListNode cur1 = listNode1;
        ListNode cur2 = listNode2;
        ListNode dummyHead = new ListNode(-1);
        ListNode resultCur = dummyHead;
        while (cur1 != null || cur2 != null) {

            if (cur1 != null) {
                resultCur.next = new ListNode(cur1.e);
                resultCur = resultCur.next;
                cur1 = cur1.next;
            }
            if (cur2 != null) {
                resultCur.next = new ListNode(cur2.e);
                resultCur = resultCur.next;
                cur2 = cur2.next;
            }
        }
        return dummyHead.next;
    }

    /**
     * 14
     *
     * @param l1
     * @param l2
     * @return org.javacore.leetCode.linkedlist.ListNode
     * @description //有序链表合并
     * @author ddfhznq
     * @date 2019-11-26 10:03:36
     */
    public static ListNode sortedMerge(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode result = new ListNode(-1);
        ListNode curResult = result;
        while (cur1 != null && cur2 != null) {
            if (cur1.e.compareTo(cur2.e) <= 0) {
                curResult.next = new ListNode(cur1.e);
                cur1 = cur1.next;
            } else {
                curResult.next = new ListNode(cur2.e);
                cur2 = cur2.next;
            }
            curResult = curResult.next;
        }

        if (cur1 != null) {
            curResult.next = cur1;
        }
        if (cur2 != null) {
            curResult.next = cur2;
        }
        return result.next;
    }


    public static List<ListNode> divide(ListNode head, ListNode one, ListNode two) {

        List result = new ArrayList();
        // Split the nodes to these 'a' and 'b' lists
        ListNode current = head;
        while (current != null) {
            // Move a node to 'a'

            ListNode newNode = current;    // the front source node
            current = current.next;    // Advance the source

            newNode.next = one;    // Link the old dest off the new node
            one = newNode;            // Move dest to point to the new node

            if (current != null) {
                // Move a node to 'b'

                newNode = current;    // the front source node
                current = current.next; // Advance the source

                newNode.next = two;    // Link the old dest off the new node
                two = newNode;            // Move dest to point to the new node
            }
        }
        result.add(one);
        result.add(two);
        return result;
    }

    /**
     * 15 归并排序
     *
     * @param head
     */
    public static void mergeSort(ListNode head) {


    }

    /**
     * 17
     * 链表反转
     *
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head) {
        ListNode result = null;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            head.next = result;
            result = head;
            head = cur;
        }

        return result;
    }

    /**
     * 2. Add Two Numbers
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2) {
        ListNode<Integer> dummyNode = new ListNode(-1);
        ListNode<Integer> p = l1, q = l2, cur = dummyNode;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.e : 0;
            int y = (q != null) ? q.e : 0;
            int data = x + y + carry;
            carry = data / 10;
            cur.next = new ListNode(data % 10);
            cur = cur.next;
            if (q != null) q = q.next;
            if (p != null) p = p.next;
        }

        return dummyNode.next;
    }
}
