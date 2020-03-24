package com.smartcloud.common.leetCode.practice;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Date 18/10/25 上午9:37
 * @Auther znq
 * @ClassName ThreeSum
 **/
public class ThreeSum {

    /**
     * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
     * Find all unique triplets in the array which gives the sum of zero.
     * <p>
     * Note:
     * <p>
     * The solution set must not contain duplicate triplets.
     * <p>
     * Example:
     * <p>
     * Given array nums = [-1, 0, 1, 2, -1, -4],
     * <p>
     * A solution set is:
     * [
     * [-1, 0, 1],
     * [-1, -1, 2]
     * ]
     */
    public List<List<Integer>> threeSum(int[] nums) {
        return getSonSet2(nums, nums.length);
    }
    /*
     *按位对应法。
     */

    /**
     * 还有一种思想比较巧妙，可以叫按位对应法。如集合A={a,b,c},
     * 对于任意一个元素，在每个子集中，要么存在，要么不存在。
     * 映射为子集：
     * (a,b,c)
     * (1,1,1)->(a,b,c)
     * (1,1,0)->(a,b)
     * (1,0,1)->(a,c)
     * (1,0,0)->(a)
     * (0,1,1)->(b,c)
     * (0,1,0)->(b)
     * (0,0,1)->(c)
     * (0,0,0)->@(@表示空集)
     * 观察以上规律，与计算机中数据存储方式相似
     * ，故可以通过一个整型数与集合映射00…00 ~ 11…11（1表示有，0表示无，反之亦可），通过该整型数逐次增可遍历获取所有的数，即获取集合的相应子集。
     *
     * @param arr
     * @param length
     */
    private static List<List<Integer>> getSonSet2(int[] arr, int length) {
        Arrays.sort(arr);
        int mark = 0;
        int nEnd = 1 << length;
        List<List<Integer>> result = new ArrayList<>();
//        Set<List<Integer>> listSet = Sets.newHashSet();
        List<Integer> subResult = null;
        for (mark = 0; mark < nEnd; mark++) {
            subResult = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                if (((1 << i) & mark) != 0) {//该位有元素输出
                    subResult.add(arr[i]);
                }
            }
            if (subResult != null && subResult.size() == 3 && isZero(subResult)) {
                Collections.sort(subResult);
                if (result.contains(subResult)) continue;
                result.add(subResult);
            }

        }
//        result.addAll(listSet);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {6, -5, -6, -1, -2, 8, -1, 4, -10, -8, -10, -2, -4, -1, -8, -2, 8, 9, -5, -2, -8, -9, -3, -5};
//        int nums []= {-1, 0, 1, 2, -1, -4};
        long start = System.currentTimeMillis();
        System.out.println(getSonSet2(nums, nums.length));
//        System.out.println(threeSum1(nums));
        long end = System.currentTimeMillis();
        System.out.println(end - start + " ms");
    }

    private static Boolean isZero(List<Integer> list) {
        int sum = 0;
        for (Integer i : list) {
            sum += i;
        }
        if (sum == 0) return Boolean.TRUE;
        return Boolean.FALSE;
    }

    public static List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int target = 0;
        for (int i = 0; i < nums.length; i++) {
            //to check the duplicate compare it with prev no
            // if u do i + 1 < nums[i] != nums[i+1] yoou will miss
            //some number.
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            } else {
                twoSum(nums, i, target - nums[i], result);
            }
        }
        System.out.println(result);
        return result;

    }

    private static void twoSum(int[] nums, int i, int target, List<List<Integer>> result) {
        int num = nums[i];
        int j = nums.length - 1;
        i = i + 1;
        while (i < j) {
            if (nums[i] + nums[j] < target) {
                i++;
            } else if (nums[i] + nums[j] > target) {
                j--;
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                temp.add(nums[j]);
                temp.add(num);
                result.add(temp);
                i++;
                j--;
                while (i < j && nums[i] == nums[i - 1]) {
                    i++;
                }
                while (i < j && nums[j] == nums[j + 1]) {
                    j--;
                }

            }
        }
    }
}
