package com.smartcloud.common.utils.leetCode.sort;

import org.javacore.arithmetic.Code_04_QuickSort;

import java.util.Arrays;

/**
 * 自己实现快排
 *
 * @Date 19/5/14 上午9:22
 * @Auther znq
 * @ClassName MyQuickSort
 **/
public class MyQuickSort {

    public static void main(String[] args) {
        int[] arr = {45, 3, 56, 23, 5, 23, 14};
        myQuickSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void myQuickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            //随机从数组中选择一个和最大坐标交换
//            Code_04_QuickSort.swap(arr, l + (int) Math.random() * (r - l + 1), r);
            int p = partition(arr, l, r);
            quickSort(arr, l, p - 1);
            quickSort(arr, p + 1, r);
        }
    }


    public static int partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l] < arr[r]) {
                Code_04_QuickSort.swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                Code_04_QuickSort.swap(arr, --more, l);
            } else {
                l++;
            }
        }
        Code_04_QuickSort.swap(arr, more, r);
        return less + 1;
    }

}
