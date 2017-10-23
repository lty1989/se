package com.se.algorithm;

/**
 * Created by lty on 2017-10-12.
 */
public class SearchTest {

    public static int binarySearch(int[] array, int searchKey) {

        if (array == null || array.length < 0) {
            return -1;
        }
        int low = 0;
        int hight = array.length - 1;
        while (low <= hight) {
            int middle = (low + hight) / 2;
            if (searchKey == array[middle]) {
                return middle;
            } else if (searchKey < array[middle]) {
                hight = middle - 1;
            } else if (searchKey > array[middle]) {
                low = middle + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] array = {20, 21, 50, 80, 84, 90, 93, 100};
        System.out.println(binarySearch(array,50));

    }
}
