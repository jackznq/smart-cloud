package com.smartcloud.common.leetCode.practice;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        int nums1[] = {1,2};
        int nums2[] = {-1, 3};
        System.out.println(new TwoSum().findMedianSortedArrays(nums1,nums2));
    }

    /**
     * 给定一个整数数组，返回两个数字的索引，使它们加起来成为一个特定的目标。
     * <p>
     * 您可能会认为每个输入都只有一个解决方案，而且您可能不会使用相同的元素两次。
     * <p>
     * 例：
     * 给定nums = [2,7,11,15]，目标= 9，
     * <p>
     * 由于nums [ 0 ] + nums [ 1 ] = 2 + 7 = 9，
     * 返回[ 0，1 ]。
     * Created by ddfhznq on 2017/11/20.
     */
    public static int[] twoSum(int[] nums, int target) {

        int a[] = new int[2];
        //取第二个数字
        int secondNum = 0;
        for (int i = 0; i < nums.length; i++) {
            secondNum = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (secondNum == nums[j]) {
                    a[0] = i;
                    a[1] = j;
                    return a;
                }
            }
        }
        return null;
    }

    /**
     * There are two sorted arrays nums1 and nums2 of size m and n respectively.
     * <p>
     * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
     * <p>
     * You may assume nums1 and nums2 cannot be both empty.
     *
     * @param nums1
     * @param nums2
     * @return
     */

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length == 0) {
            return getSingleArrayValue(nums2);
        }
        if (nums2.length == 0) {
            return getSingleArrayValue(nums1);
        }
        //判断两个数组的长度和是基数还是偶数
        //基数则取中间的数，偶数取中间两个数的和一半
        int length1 = nums1.length;
        int length2 = nums2.length;
        int count = length1 + length2;
        int middle = count / 2;
        Boolean isSingle = count % 2 == 0 ? Boolean.FALSE : Boolean.TRUE;
        //两个数组都是有序的，可以考虑几种特殊的情况
        //0、如果特殊值，所有值都相等，则随意返回其中一个值即可
        if (nums1[0]==nums2[length2-1]){
            return (double)nums1[0];
        }
        //两个数组刚好有序
        //1、数组1最大值<= 数组2 的最小值
        if (nums1[length1 - 1] <= nums2[0]) {
            return getValue(isSingle, middle, nums1, nums2);
        }

        //2、数组2最大值<= 数组1 的最小值
        if (nums1[0] >= nums2[length2 - 1]) {
            return getValue(isSingle, middle, nums2, nums1);
        }
        //3、如果不规则，需要对数组进行排序
        nums1 = Arrays.copyOf(nums1, length1 + length2);//数组扩容
        System.arraycopy(nums2, 0, nums1, length1, length2);
      return   getSingleArrayValue(nums1);
    }

    private  double getValue(Boolean isSingle, int middle, int[] nums1, int nums2[]) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        if (isSingle) {
            if (length1 < length2) {
                return (double) nums2[Math.abs(length2 - middle-1)];
            } else {
                return (double) nums1[middle];
            }

        } else {
            if (middle == length1) {
                //中位数各取一个
                return (double) (nums1[length1 - 1] + nums2[0]) / 2;
            }
            //中位数在nums2
            if (middle > length1) {
                return (double) (nums2[middle - length1 - 1]+nums2[middle-length1]) / 2;
            }
            //中位数在nums1
            if (middle > length2) {
                return (double) (nums1[middle - 1]+nums1[middle]) / 2;
            }
        }
        return 0;
    }
    private  double getSingleArrayValue(int nums[]) {
        Arrays.sort(nums);
        int count = nums.length;
        Boolean isSingle = count % 2 == 0 ? Boolean.FALSE : Boolean.TRUE;
        if (isSingle) {
            return (double) nums[count / 2];
        }
        return  (nums[count / 2-1] + nums[count / 2]) / 2D;

    }
}
