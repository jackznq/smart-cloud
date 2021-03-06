package com.smartcloud.common.utils.leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LeetCode {

    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        char[] chars1 = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
//        System.out.println(compress(chars1));
        int can[] = {10, 1, 2, 2, 2, 4, 4, 7, 6, 1, 5};
//        List<List<Integer>> lists = combinationSum(can, 12);
//        List<List<Integer>> lists = combinationSum2(can, 12);
//        List<List<Integer>> lists = combinationSum3(3, 7);
//        System.out.println(lists);
        int nums[] = {2, -1, 2, 5, 7, 4};
//        System.out.println(Arrays.toString(twoSum(nums, 20)));
//        System.out.println(shortestSubarray(nums, 140));
//        System.out.println(getHint("1101", "1011"));
//        System.out.println(rob(nums));
        ListNode one = new ListNode(1);
        one.next = new ListNode(2);

//        System.out.println(rotateRight(one, 1));
        System.out.println(shortestSubarray(nums, 8));
    }

    public static int compress(char[] chars) {

        if (chars.length < 2) return chars.length;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.putIfAbsent(c, 1);
            }
        }
        List<Character> res = new ArrayList();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            res.add(entry.getKey());
            if (entry.getValue() > 1) {
                String s = String.valueOf(entry.getValue());
                char[] temp = s.toCharArray();
                Stream stream = Stream.of(temp);
                List collect = (List<Character>) stream.collect(Collectors.toList());
                res.addAll(collect);
            }
        }
        return res.size();
    }

    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        System.out.println(Arrays.toString(candidates));
        help(candidates, 0, temp, target, res);

        return res.stream().distinct().collect(Collectors.toList());
    }

    public static void help(int[] can, int start, List<Integer> each, int tartget, List<List<Integer>> res) {
        for (int i = start; i < can.length; i++) {
            List<Integer> temp = new ArrayList<>(each);
            if (i > start && can[i] == can[i - 1]) {
                //remove duplicates;USE for combinationSum2
                System.out.println("remove duplicates");
                continue;
            } else if (can[i] == tartget) {
                temp.add(can[i]);
                res.add(temp);
                break;
            } else if (can[i] < tartget) {
                temp.add(can[i]);
                help(can, i + 1, temp, tartget - can[i], res);
            } else {
                break;
            }
        }
    }

    /**
     * @param candidates candidates
     * @param target     target
     * @return List
     */
    private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        System.out.println(Arrays.toString(candidates));
        help(candidates, 0, new ArrayList<>(), target, res);
        return res;
    }

    /**
     * Find all possible combinations of k numbers that add up to a number n,
     * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
     * <p>
     * Note:
     * <p>
     * All numbers will be positive integers.
     * The solution set must not contain duplicate combinations.
     * Example 1:
     * <p>
     * Input: k = 3, n = 7
     * Output: [[1,2,4]]
     * Example 2:
     * <p>
     * Input: k = 3, n = 9
     * Output: [[1,2,6], [1,3,5], [2,3,4]]
     *
     * @param k
     * @param n
     * @return
     */
    public static List<List<Integer>> combinationSum3(int k, int n) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        if (n == 0) return Collections.EMPTY_LIST;
        help(arr, 0, new ArrayList<>(), n, res);
        Iterator iterator = res.iterator();
        while (iterator.hasNext()) {
            List<Integer> next = (List<Integer>) iterator.next();
            if (next.size() != k) {
                iterator.remove();
            }
        }
        return res;
    }

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * <p>
     * 示例:
     * <p>
     * 给定 nums = [2, 7, 11, 15], target = 9
     * <p>
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {

        int res[] = new int[2];
        for (int a = 0; a < nums.length; a++) {
            int i = target - nums[a];
            res[0] = a;
            for (int b = a + 1; b < nums.length; b++) {
                if (i == nums[b]) {
                    res[1] = b;
                    return res;
                }
            }
        }
        return null;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     * <p>
     * 示例：
     * <p>
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     * <p>
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     * 说明：
     * <p>
     * 给定的 n 保证是有效的。
     * <p>
     * 进阶：
     * <p>
     * 你能尝试使用一趟扫描实现吗？
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 1) {
            return head;
        }
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            n--;
        }
        if (n > 0) {
            return head;
        }
        if (n == 0) return head.next;
        if (n < 0) {
            cur = head;
            while (++n != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }


    class MyQueue {

        private List<Integer> list;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            list = new ArrayList();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            list.add(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            return list.remove(0);
        }

        /**
         * Get the front element.
         */
        public int peek() {
            return (Integer) list.get(0);
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return list.size() == 0;
        }
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                res.add(nums[i]);
            }
        }
        return res;
    }
//
//    public static int shortestSubarray(int[] A, int K) {
//        if (A.length == 0) return -1;
//        Arrays.sort(A);
//        List<List<Integer>> res = new ArrayList<>();
//        dfs(A, 0, res, new ArrayList<>(), K);
//        if (res.size() == 0) return -1;
//        int data = Integer.MAX_VALUE;
//        for (List list : res) {
//            if (list.size() < data) {
//                data = list.size();
//            }
//        }
//        return data;
////           return res.stream().sorted(Comparator.comparing())
//    }

//    public static void dfs(int[] nums, int start, List<List<Integer>> res, List<Integer> temp, int target) {
//        for (int i = start; i < nums.length; i++) {
//            List<Integer> each = new ArrayList<>(temp);
//            if (nums[i] >= target) {
//                each.add(nums[i]);
//                res.add(each);
//                break;
//            } else if (nums[i] < target) {
//                each.add(nums[i]);
//                dfs(nums, i + 1, res, each, target - nums[i]);
//            }
//        }
//    }

    /**
     * 返回 A 的最短的非空连续子数组的长度，该子数组的和至少为 K 。
     * <p>
     * 如果没有和至少为 K 的非空子数组，返回 -1 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：A = [1], K = 1
     * 输出：1
     * 示例 2：
     * <p>
     * 输入：A = [1,2], K = 4
     * 输出：-1
     * 示例 3：
     * <p>
     * 输入：A = [2,-1,2], K = 3
     * 输出：3
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= A.length <= 50000
     * -10 ^ 5 <= A[i] <= 10 ^ 5
     * 1 <= K <= 10 ^ 9
     *
     * @param A
     * @param K
     * @return
     */
    public static int shortestSubarray(int[] A, int K) {
        if (A.length == 0) return -1;
//        TreeMap<Long, Integer> tree = new TreeMap<>();
//        long total = 0;
//        int minLen = Integer.MAX_VALUE;
//        for (int i = 0; i < A.length; i++) {
//            total += A[i];
//            Long num = tree.floorKey(total - K);
//            if (total >= K) {
//                if (i + 1 < minLen) {
//                    minLen = i + 1;
//                }
//            }
//            while (num != null) {
//                if (i - tree.get(num) < minLen) {
//                    minLen = i - tree.get(num);
//                }
//                tree.remove(num);
//                num = tree.lowerKey(num);
//            }
//            tree.put(total, i);
//        }
//        return minLen == Integer.MAX_VALUE ? -1 : minLen;
        int N = A.length;
        long[] P = new long[N + 1];
        for (int i = 0; i < N; ++i)
            P[i + 1] = P[i] + (long) A[i];

        // Want smallest y-x with P[y] - P[x] >= K
        int ans = N + 1; // N+1 is impossible
        Deque<Integer> monoq = new LinkedList(); //opt(y) candidates, as indices of P

        for (int y = 0; y < P.length; ++y) {
            // Want opt(y) = largest x with P[x] <= P[y] - K;
            while (!monoq.isEmpty() && P[y] <= P[monoq.getLast()])
                monoq.removeLast();
            while (!monoq.isEmpty() && P[y] >= P[monoq.getFirst()] + K){

                Integer removeFirst = monoq.removeFirst();
                int min = Math.min(ans, y - removeFirst);
                System.out.println("最小值ans:"+min+"位置:"+y+"removeFirst:"+removeFirst);
                ans = min;
            }

            monoq.addLast(y);
        }

        return ans < N + 1 ? ans : -1;
    }

    public static String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) bulls++;
            else {
                if (numbers[secret.charAt(i) - '0']++ < 0) cows++;
                if (numbers[guess.charAt(i) - '0']-- > 0) cows++;
            }
        }
        return bulls + "A" + cows + "B";
    }

    public static int rob(int[] nums) {
        int prevNo = 0;
        int prevYes = 0;
        for (int n : nums) {
            int temp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = n + temp;
        }
        return Math.max(prevNo, prevYes);
    }

    public static ListNode rotateRight(ListNode head, int k) {

        if (head == null) return head;
        if (head.next == null) return head;
        if (k < 1) return head;
        for (int i = 0; i < k; i++) {
            ListNode pre = null;
            ListNode cur = head;
            while (cur != null) {
                if (cur.next.next == null) {
                    pre = cur.next;
                    cur.next = null;
                    break;
                }
                cur = cur.next;
            }
            pre.next = head;
            head = pre;
        }

        return head;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        List<Integer> res = new ArrayList<>();
        for (ListNode ln : lists) {
            if (ln != null) {
                res.add(ln.val);
                ln = ln.next;
            }
        }

        Collections.sort(res);
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        for (int i : res) {
            ListNode temp = new ListNode(i);
            cur.next = temp;
            cur = cur.next;
        }
        cur.next = null;
        return pre.next;
    }

}
