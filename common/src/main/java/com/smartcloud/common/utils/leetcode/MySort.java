package com.smartcloud.common.utils.leetcode;

import java.util.Arrays;

public class MySort {
    public static void main(String[] args) {
        int[] arr = {6, 4, 67, 3, 15, 24};
//        bubblSort(arr);
//        insertSort(arr);
        selectSort(arr);
    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void bubblSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        printArr(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        printArr(arr);
    }

    /**
     * 插入排序
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        printArr(arr);
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }

        printArr(arr);
    }


    /**
     * 选择排序
     * 6, 4, 67, 3, 15, 24
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        printArr(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(arr, i, min);
            }

        }
        printArr(arr);
    }

    public static void printArr(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
