package com.se.algorithm.sort;

import java.util.Arrays;

/**
 * Created by lty on 2017-10-18.
 */
public class HeapSort {


    public static void main(String[] args) {
        int[] a = {2, 20, 54, 12, 8, 6, 4};
        sort(a);
        System.out.println(Arrays.toString(a));
    }


    public static void sort(int[] a) {
        int size = a.length;
        for (int i = 0; i < size - 1; i++) {
            buildMaxHeap(a, size - 1 - i);
            swap(a, 0, size - 1 - i);
        }


    }


    public static void buildMaxHeap(int[] a, int lastIndex) {
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            int k = i;
            while (2 * k + 1 <= lastIndex) {
                int biggerIndex = 2 * k + 1;
                if (biggerIndex < lastIndex) {
                    if (a[biggerIndex] < a[biggerIndex + 1]) {
                        biggerIndex++;
                    }
                }

                if (a[k] < a[biggerIndex]) {
                    swap(a, k, biggerIndex);
                    k = biggerIndex;
                } else {
                    break;
                }

            }

        }
    }


    public static void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

}
