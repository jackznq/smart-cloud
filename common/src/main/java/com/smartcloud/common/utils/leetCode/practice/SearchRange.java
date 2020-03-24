package com.smartcloud.common.utils.leetCode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定按升序排序的整数数组，找到给定目标值的开始和结束位置。
 * <p>
 * 您的算法的运行时复杂度必须按照O（log n）的顺序。
 * <p>
 * 如果在数组中找不到目标，则返回[-1, -1]。
 * <p>
 * 例如，
 * 给定[5, 7, 7, 8, 8, 10]和目标值8，
 * 返回[3, 4]。
 * Search for a Range
 * Created by ddfhznq on 2017/11/20.
 */
public class SearchRange {

    public static void main(String[] args) {
        int a[] = new int[]{5,7,7,8,8,8,8,10};
//        int a[] = new int[]{3,3,3};
        int[] b = searchRange(a, 8);
        System.out.println(Arrays.toString(b));
    }

    public static int[] searchRange(int[] nums, int target) {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                integerList.add(i);
            }
        }
        if (integerList.size() > 0) {
            int len=integerList.size();
            int[] integers;
            if (len==1){
                integers =new int[len+1];
            } else {
                integers =new int[len];
            }
            for (int i = 0; i < len; i++) {

                integers[i] = integerList.get(i);
                if (len==1){
                    integers[i+1] = integerList.get(i);
                }

            }
            if (integers.length>2){
                int target2[] =new int[2];
                target2[0]=integers[0];
                target2[1]=integers[integers.length-1];
                return target2;
            }
            return integers;

        } else {
            return new int[]{-1, -1};
        }

    }
}
