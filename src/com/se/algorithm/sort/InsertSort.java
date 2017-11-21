package com.se.algorithm.sort;

import java.util.Arrays;

/**
 * Created by lty on 2017-10-18.
 */
public class InsertSort {


    public static void main(String[] args) {
        int[] a = {2, 20, 54, 12, 8, 6, 4};
        sort(a);
        System.out.println(Arrays.toString(a));
    }


    public static void sort(int[] arr) {
        int size = arr.length;
        System.out.println("开始排序：");


        for (int i = 1; i < size; i++) {
            int tmp = arr[i];
            if (arr[i] < arr[i - 1]) {
                int j = i - 1;
                for (; j >= 0 && arr[j] > tmp; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[j + 1] = tmp;
            }
            System.out.println("第" + i + "趟-->" + Arrays.toString(arr));
        }
    }


}
