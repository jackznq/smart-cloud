package com.smartcloud.common.utils.leetCode.queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @Date 18/11/29 下午10:31
 * @Auther znq
 * @ClassName SlidingWindowMaximum
 **/
public class SlidingWindowMaximum {


    //双端队列初始化
    private static Deque<Integer> deque;

    /**
     * 239. Sliding Window Maximum
     * 解法:用有限队列或者双端队列
     *
     * @param nums
     * @param k
     * @return
     * @see java.util.PriorityQueue
     * @see Deque
     * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return nums;
        }
        if (nums.length == 1 && k == 1) {
            return nums;
        }
        if (nums.length > 1 && k == 1) {
            return nums;
        }
        int[] resultNums = new int[nums.length - k + 1];
        deque = new ArrayDeque(k);
        int j = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {

            if (i <= k - 1) {
                if (deque.isEmpty()) {
                    deque.add(nums[i]);
                    max = nums[i];
                    continue;
                }
                deque.add(nums[i]);
                if (max < nums[i]) {
                    max = nums[i];
                }

            }
            resultNums[0] = max;

            //Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
            if (i > k - 1) {
                if (deque.size() == 1) {
                    Integer peek = deque.peek();
                    deque.add(nums[i]);
                    if (peek > nums[i]) {
                        resultNums[j] = peek;
                    } else {
                        resultNums[j] = nums[i];
                    }
                    j++;
                    continue;
                }
                Integer pollFirst = deque.pollFirst();
                Integer peekFirst;
                if (pollFirst < nums[i]) {
                    resultNums[j] = nums[i];
                    peekFirst = deque.peekFirst();
                    while (peekFirst < nums[i] && deque.size() > 0) {
                        if (!deque.isEmpty()) {
                            deque.pollFirst();
                        }
                    }
                    deque.add(nums[i]);
                } else {
                    peekFirst = deque.peekFirst();
                    if (peekFirst > nums[i]) {
                        resultNums[j] = peekFirst;
                    } else {
                        resultNums[j] = nums[i];
                        while (peekFirst < nums[i] && deque.size() > 0) {
                            if (!deque.isEmpty()) {
                                deque.pollFirst();
                            }
                        }
                    }
                    deque.add(nums[i]);
                }
                j++;
            }
        }
        return resultNums;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
//        int[] nums = {7, 2, 4};
//        int[] nums = {1, -1};
        int[] nums = {1,3,1,2,0,5};
        int k = 3;
        int[] ints = maxSlidingWindow(nums, k);
        Arrays.toString(ints);

    }
}
