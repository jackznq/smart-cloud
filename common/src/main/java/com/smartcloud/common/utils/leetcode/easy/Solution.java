package com.smartcloud.common.utils.leetcode.easy;

import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    public static int removeDuplicates(int[] nums) {

        //检查无效数组
        if (nums.length == 0) {
            return 0;
        }
        int k = 1;

        //循环整个数组，并从nums[1]开始，可以有效的防止数组越界的情况发生
        for (int i = 1; i < nums.length; i++) {

            //当nums[i]和nums[i-1]相等时，跳过本次循环，也就是去重复值；
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            //将不重复的值重新赋给数组
            nums[k++] = nums[i];
        }
        return k;

    }

    public boolean containsDuplicate(int[] nums) {

        if (nums == null || nums.length == 0) {
            return false;
        }
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) return true;
        }
        return false;
    }

    public int singleNumber(int[] nums) {

        return 0;
    }

    public static void main(String[] args) {
        int nums[] = {1, 1, 1, 2, 2, 3, 3, 4, 4};
        removeDuplicates(nums);
    }
}