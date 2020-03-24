package com.smartcloud.common.utils.leetCode.sort;

import java.util.Arrays;

/**
 * 自己写的归并排序
 *
 * @Date 19/5/13 下午3:10
 * @Auther znq
 * @ClassName MyMergeSort
 **/
public class MyMergeSort {

    public static void main(String[] args) {

        int arr[] = {5, 3, 4, 19, 50, 24, 56, 14};
        myMergeSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void myMergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }

        int mid = (l + r) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p = l;
        int q = mid + 1;
        while (p <= mid && q <= r) {
            help[i++] = arr[p] < arr[q] ? arr[p++] : arr[q++];
        }
        while (p <= mid) {
            help[i++] = arr[p++];
        }
        while (q <= r) {
            help[i++] = arr[q++];
        }

        int result = 0;
        while (result < help.length) {
            arr[l + result] = help[result];
            result++;
        }

    }

}
