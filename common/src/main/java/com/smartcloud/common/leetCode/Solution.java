package com.smartcloud.common.leetCode;

import org.javacore.leetCode.linkedlist.ListNode;
import org.javacore.leetCode.tree.TreeNode;

import java.math.BigInteger;
import java.util.*;

/**
 * @Auther: znq
 * @Date: 18/7/30 22:44
 * @Description:leetCode练习
 */
public class Solution {
    /**
     * String to Integer (atoi)
     *
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
        if (Character.isLetter(str.charAt(0)) || str.startsWith(" ") || str.startsWith("''")) {
            return 0;
        }
        str = str.trim();
        if (str.startsWith("-")) {
            String strTemp = str.substring(1, str.length());
            if (isdigit(strTemp)) {
                BigInteger integer = new BigInteger(strTemp);
                if (integer.compareTo(new BigInteger("2147483648")) > 0) {
                    return -2147483648;
                } else {
                    return Integer.parseInt("-" + strTemp);
                }
            }
            myAtoi(strTemp);
        } else if (str.startsWith("+")) {
            String strTemp = str.substring(1, str.length());
            if (isdigit(strTemp)) {
                return Integer.parseInt(strTemp);
            }
            myAtoi(strTemp);
        } else {
            String subString;
            for (int i = 1; i < str.length(); i++) {
                if (Character.isLetter(str.charAt(i)) || Character.isWhitespace(str.charAt(i))) {
                    if (i >= 0) {
                        subString = str.substring(0, i);
                        return Integer.parseInt(subString);
                    }
                }
            }

            return Integer.parseInt(str);
        }
        return 0;
    }

    private static boolean isdigit(String str) {
        return str.matches("[0-9]+");
    }


    public static void main(String[] args) {
//        String s = "-91283472332";
////        System.out.println(myAtoi(s));
//        int[] nums = {1, 1, 2, 2, 3, 5, 5, 5, 5, 6};
//        List ints = Arrays.asList(nums);
//        Set set = new HashSet(ints);
//        System.out.println(set.toArray());
//        System.out.println(removeDuplicates(nums));
//        int[] nums = {4, 4, 1, 2, 1, 2, 5};
//        int i = singleNumber(nums);
//        System.out.println(i);

//        twoSum(nums, 26);
//        TreeNode leftLeft = new TreeNode(4);
//        left.left = leftLeft;
//        right.left = rightLeft;
//        right.right = rightRight;
//        isValidBS(root);
//        ListNode one = new ListNode(1);
//        ListNode two = new ListNode(1);
//        ListNode three = new ListNode(3);
//        ListNode four = new ListNode(2);
//        ListNode five = new ListNode(5);
//        ListNode six = new ListNode(2);
//        one.next = two;
//        two.next = three;
//        three.next = four;
//        four.next = five;
//        five.next = six;
//        ListNode partition = partition1(one, 3);
//        System.out.println(partition.toString());
//        int a[] = {4, 6, 7, 3, 5, 8};
//        Arrays.toString(sortArrayByParityII(a));
        frequencySort("Aabb");
        int [] arr ={3,2,1,5,6,4};
        findKthLargest(arr,2);
    }

    public static int removeDuplicates(int[] nums) {
        int count = 1;
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                break;
            }
            if (i != 0) {
                if (nums[i] != nums[i + 1]) {
                    count++;
                } else {
                    nums[i] = nums[i + 1];
                }
            }
        }
        for (int i = 0; i < count; i++) {
            System.out.println(nums[i]);
        }
        return count;
    }

    public static int[] delete(int index, int array[]) {
        //根据删除索引，把数组后面的向前移一位
        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        return array;
    }

    public boolean containsDuplicate(int[] nums) {
        Set set = new HashSet();
        for (int i : nums) {
            if (set.contains(i)) {
                return Boolean.TRUE;
            }
            set.add(i);
        }
        return Boolean.FALSE;
    }

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，
     * 其余每个元素均出现两次。找出那个只出现了一次的元素。
     * 说明：
     * 你的算法应该具有线性时间复杂度，你可以不使用额外空间来实现吗？
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {

        int count = 0;
        int result = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                    index = j;
                    break;
                }
            }
            if (i == 0 && index == 0) {
                return nums[0];
            }
            if (i == index) {
                continue;
            }
            if (i != 0) {

                if (count == 0) {
                    return nums[i];
                }
            }
            count = 0;

        }
        return result;
    }
    //[2,2,1]

    /**
     * 说明：
     * <p>
     * 输出结果中每个元素出现的次数，
     * 应与元素在两个数组中出现的次数一致。
     * 我们可以不考虑输出结果的顺序。
     * 进阶:
     * <p>
     * 如果给定的数组已经排好序呢？你将如何优化你的算法？
     * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
     * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        int size = nums1.length < nums2.length ? nums2.length : nums1.length;
        int result[] = {};
        int count = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int aNums2 : nums2) {
                if (nums1[i] == aNums2) {
                    count++;
                    result[i] = nums1[i];
                }
            }
        }
        return result;
    }


    /**
     * 458. Poor Pigs
     *
     * @param buckets
     * @param minutesToDie
     * @param minutesToTest
     * @return
     */
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int i = minutesToTest / minutesToDie;
        return buckets / i;
    }

    /**
     * Given an array of integers, return indices of
     * the two numbers such that they add up to a specific target.
     * <p>
     * You may assume that each input would have exactly one solution,
     * and you may not use the same element twice.
     * <p>
     * Example:
     * <p>
     * Given nums = [2, 7, 11, 15], target = 9,
     * <p>
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {

        if (null == nums) {
            return null;
        }
        int result[] = new int[2];
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int a = target - nums[i];
            result[0] = i;
            Boolean isTrue = false;
            for (int j = i + 1; j < nums.length; j++) {
                if (a == nums[j]) {
                    result[1] = j;
                    isTrue = true;
                    break;
                }
            }
            if (isTrue) {
                return result;
            }
        }
        return null;
    }

    /**
     * 98. Validate Binary Search Tree
     *
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        return preOrderRec(root);

    }

    public static Boolean preOrderRec(TreeNode root) {
        Boolean isLarger = true;
        Boolean isSmaller = true;
        if (root != null) {
            TreeNode left = root.left;
            Comparable e = root.e;
            TreeNode right = root.right;

            if (left != null && left.e.compareTo(e) > 0) {
                isSmaller = false;
            }
            if (right != null && right.e.compareTo(e) < 0) {
                isLarger = false;

            }
            preOrderRec(left);
            System.out.println(e);
            preOrderRec(right);
        }
        return isLarger && isSmaller;
    }


    /**
     * 判断是否是二叉搜索树
     * 用中序遍历
     *
     * @param root
     * @return
     */
    public static boolean isValidBS(TreeNode root) {
        return isValidBS(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidBS(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.e.compareTo(maxVal) >= 0 || root.e.compareTo(minVal) <= 0) return false;
        return isValidBS(root.left, minVal, (long) root.e) && isValidBS(root.right, (long) root.e, maxVal);
    }


    /**
     * Given a linked list and a value x,
     * partition it such that all nodes less than x come before nodes greater than or equal to x.
     * <p>
     * You should preserve the original relative order of the nodes in each of the two partitions.
     * <p>
     * Example:
     * <p>
     * Input: head = 1->4->3->2->5->2, x = 3
     * Output: 1->2->2->4->3->5
     *
     * @param head
     * @param x
     * @return
     */
    public static ListNode partition(ListNode<Integer> head, int x) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode smalNode = null;
        ListNode lagerNode = null;
        while (head != null) {
            int val1 = head.e;
            head = head.next;
            if (val1 < x) {
                if (smalNode == null) {
                    smalNode = new ListNode(val1);
                    continue;
                }
                insertListNode(smalNode, val1);
            } else {
                if (lagerNode == null) {
                    lagerNode = new ListNode(val1);
                    continue;
                }
                insertListNode(lagerNode, val1);
            }
        }
        if (lagerNode == null) return smalNode;
        if (smalNode == null) return lagerNode;
        ListNode cur = smalNode;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = lagerNode;
        return smalNode;
    }

    private static void insertListNode(ListNode cur, int val) {
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new ListNode(val);
    }

    /**
     * example
     *
     * @param head
     * @param x
     * @return
     */
    public static ListNode partition1(ListNode<Integer> head, int x) {
        ListNode less = new ListNode(0);
        ListNode greater = new ListNode(0);
        ListNode curr1 = less, curr2 = greater;

        while (head != null) {
            if (head.e < x) {
                curr1.next = new ListNode(head.e);
                curr1 = curr1.next;
            } else {
                curr2.next = new ListNode(head.e);
                curr2 = curr2.next;
            }
            head = head.next;
        }
        curr1.next = greater.next;
        return less.next;
    }

    /**
     * 718. Maximum Length of Repeated Subarray
     *
     * @param A
     * @param B
     * @return
     */
    public int findLength(int[] A, int[] B) {

        if (A.length == 0 || B.length == 0) {
            return 0;
        }

        for (int i = 0; i < A.length; i++) {
            int[] sub = Arrays.copyOfRange(A, 0, i);

        }

        for (int j = 0; j < A.length; j++) {

        }
        return 0;
    }


    /**
     * 922. Sort Array By Parity II
     *
     * @param A
     * @return
     */
    public static int[] sortArrayByParityII(int[] A) {
        int length = A.length;
        if (length == 0) return null;
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        for (int i : A) {
            if (i % 2 == 0) {
                even.add(i);
                continue;
            }
            odd.add(i);

        }
        int oddN = 0;
        int evenN = 0;
        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) {
                A[i] = even.get(evenN);
                evenN++;
            } else {
                A[i] = odd.get(oddN);
                oddN++;
            }
        }

        return A;
    }


    /**
     * 451. Sort Characters By Frequency
     *
     * @param s
     * @return
     */
    public static String frequencySort(String s) {
        if (s == null) {
            return s;
        }

        char[] chars = s.toCharArray();
        Map<Character, Integer> count = new TreeMap();
        for (char a : chars) {
            count.put(a, count.getOrDefault(a, 0) + 1);
        }
        PriorityQueue<Character> heap = new PriorityQueue<>((a, b) -> count.get(b) - count.get(a));

        count.keySet().forEach(i -> {
            heap.add(i);
        });
        StringBuilder sb = new StringBuilder();
        while (!heap.isEmpty()) {
            Character poll = heap.poll();
            Integer amount = count.get(poll);
            for (int i = 0; i < amount; i++) {
                sb.append(poll);
            }
        }
        return sb.toString();
    }

    public int maximumGap(int[] nums) {

        if (nums == null || nums.length < 2) {
            return 0;
        }

        return 0;
    }


    /**
     * 347. Top K Frequent Elements
     * Example 1:
     * <p> Input: nums = [1,1,1,2,2,3], k = 2
     * Output: [1,2]
     * Example 2:
     * <p>
     * Input: nums = [1], k = 1
     * Output: [1]
     *
     * @param nums
     * @param k
     * @return
     */
    public static List<Integer> topKFrequent(int[] nums, int k) {
        if (nums.length == 0) {
            return Collections.EMPTY_LIST;
        }
        List<Integer> res = new ArrayList<>();
        if (nums.length == 1) {
            res.add(nums[0]);
            return res;
        }
        Map<Integer, Integer> map = new TreeMap();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for (int count : map.keySet()) {
            heap.add(count);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        List<Integer> topK = new LinkedList();
        while (!heap.isEmpty())
            topK.add(heap.poll());
        return topK;
    }


    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        for (int i : nums) {
            heap.add(i);
        }
        int result = 0;
        while (k > 0) {
            result = heap.poll();
            k--;
        }
        System.out.println(result);
        return result;
    }
}
