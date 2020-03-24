package com.smartcloud.common.leetCode.sort;

import static org.javacore.arithmetic.Code_04_QuickSort.swap;

/**
 * @Date 19/5/14 下午2:57
 * @Auther znq
 * @ClassName MyHeapSort
 **/
public class MyHeapSort {

    public static void main(String[] args) {

    }


    public static void heapSort(int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }

        //1.构造大根堆
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        //2.heapify

    }

    /**
     * 构造大根堆
     *
     * @param arr
     * @param index
     */
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }
}
