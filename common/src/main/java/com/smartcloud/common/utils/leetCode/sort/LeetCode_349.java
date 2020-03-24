package com.smartcloud.common.utils.leetCode.sort;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Date 19/5/14 上午10:59
 * @Auther znq
 * @ClassName LeetCode_349
 **/
public class LeetCode_349 {

    public static void main(String[] args) {

    }

    /**
     * 取两个数组的交集
     * 349. Intersection of Two Arrays
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null) {
            return null;
        }
        Set<Integer> collect = Arrays.stream(nums1).mapToObj(e -> e).collect(Collectors.toSet());
        return Arrays.stream(nums2).filter(collect::contains).distinct().toArray();
    }
}
