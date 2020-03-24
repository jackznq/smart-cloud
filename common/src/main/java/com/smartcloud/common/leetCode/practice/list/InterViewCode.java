package com.smartcloud.common.leetCode.practice.list;


import com.smartcloud.common.leetCode.linkedlist.ListNode;

import java.util.HashSet;
import java.util.Stack;
import java.util.TreeSet;

/**
 * 出自<程序员代码面试指南>
 *
 * @Date 19/5/19 下午3:59
 * @Auther znq
 * @ClassName InterViewCode
 **/
public class InterViewCode {

    public static void main(String[] args) {

//        printListCommonPart(new ListNode(1), new ListNode(1));
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
//        five.next = one;
//        removeLastKthNode(one, 2);
//        revertList(one);
        ListNode head1 = new ListNode(10);
        head1.next = one;
        ListNode head2 = new ListNode(9);
        head2.next = one;

        ListNode isPolindromel1 = new ListNode(8);
        ListNode isPolindromel2 = new ListNode(9);
        ListNode isPolindromel3 = new ListNode(10);
        ListNode isPolindromel4 = new ListNode(9);
        ListNode isPolindromel5 = new ListNode(8);
        isPolindromel1.next = isPolindromel2;
        isPolindromel2.next = isPolindromel3;
        isPolindromel3.next = isPolindromel4;
        isPolindromel4.next = isPolindromel5;
//        printCommonPart(head1, head2);
//        printListCommonPart(head1, head2);
//        printListNode(removeLastKthNode(one, 3));
//        printListNode(removeMidListNode(one));
//        printListNode(josephusKill(one, 3));
//        System.out.println(isPolindromel2(isPolindromel1));
//        printListNode(addList(isPolindromel1, one));
//        printListNode(one);
        System.out.println();
//        printListNode(reverseKNodes(one, 3));
//        printListNode(removeDuplicatedNode(isPolindromel1));
//        printListNode(removeValue(one, 4));
        String[]param ={"gin", "zen", "gig", "msg"};
        uniqueMorseRepresentations(param);

    }


    /**
     * 在单链表和双链表中删除倒数第K个节点
     * 要求:时间复杂度O(n)，空间复杂度O(1)
     *
     * @param head
     */
    public static ListNode removeLastKthNode(ListNode head, int k) {

        if (head == null || k < 1) {
            return head;
        }
        ListNode pre = head;
        while (pre != null) {
            pre = pre.next;
            k--;
        }

        if (k == 0) {
            head = head.next;
        }
        if (k < 0) {
            pre = head;
            while (++k != 0) {
                pre = pre.next;
            }
            pre.next = pre.next.next;
        }
        return head;
    }


    /**
     * 反转单向链表
     * 1->2->3->4->5
     *
     * @param head
     */
    public static ListNode revertList(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode pre = null;
        ListNode cur = null;
        while (head != null) {
            cur = head.next;
            head.next = pre;
            pre = head;
            head = cur;
        }

        return pre;
    }

    /**
     * 程序员代码面试指南 打印公共的部分
     *
     * @param one
     * @param two
     */
    public static void printCommonPart(ListNode<Integer> one, ListNode<Integer> two) {
        if (one == null || two == null) {
            System.out.println("non common part");
            return;
        }
        System.out.println("print common part");
        while (one != null && two != null) {
            if (one.e == two.e) {
                System.out.println("commont part is " + one.e);
                one = one.next;
                two = two.next;
            } else if (one.e < two.e) {
                two = two.next;
            } else {
                one = one.next;
            }
            System.out.println();
        }
    }


    public static void printListNode(ListNode l) {
        if (l == null) return;
        while (l != null && l != l.next) {
            System.out.println(l.e);
            l = l.next;
        }
    }

    /**
     * 删除链表的中间节点
     * 通过快慢指针解决
     *
     * @param head
     */
    public static ListNode removeMidListNode(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        if (head.next.next == null) {
            return head.next;
        }

        ListNode pre = head;
        ListNode cur = head.next.next;
        while (cur.next != null && cur.next.next != null) {
            pre = pre.next;
            cur = cur.next.next;
        }

        pre.next = pre.next.next;
        return head;
    }


    /**
     * 反转部分链表
     *
     * @param head
     * @return
     */
    public static ListNode revertPart(ListNode head, int from, int to) {
        //先判断是否满足 1<from <to <N
        //不满足直接返回
        int len = 0;
        ListNode cur = head;
        ListNode tPre = null;
        ListNode tPos = null;
        while (cur != null) {
            len++;
            tPre = len == from - 1 ? cur : tPre;
            tPos = len == to + 1 ? cur : tPos;
            cur = cur.next;
        }
        if (from > to || from < 1 || to > len) {
            return head;
        }
        return head;
    }

    /**
     * 环形单链表的约瑟夫问题
     */
    public static ListNode josephusKill(ListNode head, int m) {
        if (head == null || m < 1 || head.next == head) {
            return head;
        }
        ListNode last = head;
        while (last.next != head) {
            last = last.next;
        }
        int count = 0;
        while (head != last) {
            if (++count == m) {
                last.next = head.next;
                count = 0;
            } else {
                last = last.next;
            }
            head = last.next;
        }
        return head;
    }


    /**
     * 判断是否是回文结构
     */
    public static boolean isPolindromel(ListNode head) {
        if (head == null && head.next == null) {
            return true;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.e != stack.pop().e) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 判断是否是回文结构
     *
     * @param head
     * @return
     */
    public static boolean isPolindromel2(ListNode head) {
        if (head == null && head.next == null) {
            return true;
        }

        ListNode right = head.next;
        ListNode cur = head;
        while (cur.next != null && cur.next.next != null) {
            right = right.next;
            cur = cur.next.next;
        }
        Stack<ListNode> stack = new Stack<>();
        while (right != null) {
            stack.push(right);
            right = right.next;
        }
        while (!stack.isEmpty()) {
            if (head.e != stack.pop().e) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 两个单链表相加的问题
     * 利用栈结构处理
     */
    public static ListNode addList(ListNode<Integer> head1, ListNode<Integer> head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (head1 != null) {
            s1.push(head1.e);
            head1 = head1.next;
        }
        while (head2 != null) {
            s2.push(head2.e);
            head2 = head2.next;
        }

        int ca = 0;
        int n1 = 0;
        int n2 = 0;
        int n = 0;
        ListNode pre = null;
        ListNode node = null;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            n1 = s1.isEmpty() ? 0 : s1.pop();
            n2 = s2.isEmpty() ? 0 : s2.pop();
            n = n1 + n2 + ca;
            pre = node;
            node = new ListNode(n % 10);
            node.next = pre;
            ca = n / 10;
        }

        if (ca == 1) {
            pre = node;
            node = new ListNode(1);
            node.next = pre;
        }
        return node;
    }

    public static ListNode reverseKNodes(ListNode head, int k) {
        if (k < 2) {
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode newHead = head;
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            stack.push(cur);
            if (stack.size() == k) {
                pre = resign(stack, pre, next);
                newHead = newHead == head ? cur : newHead;

            }
            cur = next;
        }
        return newHead;
    }

    /**
     * 反转链表
     *
     * @param stack
     * @param left
     * @param right
     * @return
     */
    private static ListNode resign(Stack<ListNode> stack, ListNode left, ListNode right) {
        ListNode cur = stack.pop();
        if (left != null) {
            left.next = cur;
        }
        ListNode next;
        while (!stack.isEmpty()) {
            next = stack.pop();
            cur.next = next;
            cur = next;
        }
        cur.next = right;
        return cur;
    }

    /**
     * 删除无序单链表的重复节点
     */
    public static ListNode removeDuplicatedNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        HashSet hashSet = new HashSet();
        ListNode pre = head;
        ListNode cur = head.next;
        hashSet.add(head.e);
        while (cur != null) {
            if (hashSet.contains(cur.e)) {
                pre.next = cur.next;
            } else {
                hashSet.add(cur.e);
                pre = cur;
            }

            cur = cur.next;
        }
        return head;
    }

    /**
     * 在链表中删除指定节点
     */
    public static ListNode removeValue(ListNode<Integer> head, int k) {
        if (head == null) {
            return head;
        }
        while (head != null) {
            if (head.e != k) {
                break;
            }
            head = head.next;
        }
        ListNode pre = head;
        ListNode<Integer> cur = head;
        while (cur != null) {
            if (cur.e == k) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    /**
     * International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
     * <p>
     * For convenience, the full table for the 26 letters of the English alphabet is given below:
     * <p>
     * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
     * Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. For example, "cba" can be written as "-.-..--...", (which is the concatenation "-.-." + "-..." + ".-"). We'll call such a concatenation, the transformation of a word.
     * <p>
     * Return the number of different transformations among all words we have.
     * <p>
     * Example:
     * Input: words = ["gin", "zen", "gig", "msg"]
     * Output: 2
     * Explanation:
     * The transformation of each word is:
     * "gin" -> "--...-."
     * "zen" -> "--...-."
     * "gig" -> "--...--."
     * "msg" -> "--...--."
     * <p>
     * There are 2 different transformations, "--...-." and "--...--.".
     *
     * @param words
     * @return
     */
    public static int uniqueMorseRepresentations(String[] words) {

//        String [] s ={"ttt","ttt"};
        String codes[] = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        TreeSet<String> result = new TreeSet<>();
        for (String w : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < w.length(); i++) {
                sb.append(codes[w.charAt(i) - 'a']);
            }

            result.add(sb.toString());
        }
        return result.size();
    }

}
