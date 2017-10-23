package com.se.algorithm.sort;

import java.util.Arrays;

/**
 * Created by lty on 2017-10-18.
 */
public class SelectSort {


    public static void main(String[] args) {
        int[] a = {2, 20, 54, 12, 8, 6, 4};
        sort(a);
        System.out.println(Arrays.toString(a));
    }


    public static void sort(int[] arr) {
        int size = arr.length;
        System.out.println("开始排序：");
        for (int i = 0; i < size - 1; i++) {
            int cminIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (arr[cminIndex] > arr[j]) {
                    cminIndex = j;
                }
            }
            System.out.println("第" + (i + 1) + "趟最小下标为" + cminIndex+",最小值为："+arr[cminIndex]);
            if (cminIndex != i) {
                System.out.println("交换");
                int temp = arr[i];
                arr[i] = arr[cminIndex];
                arr[cminIndex] = temp;
            }
            System.out.println(Arrays.toString(arr));
        }

    }


}
