package com.bj;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1, 3,90, 5, 7, 9, 11, 16, 45};
        qucik(arr, 0, arr.length - 1);
        System.out.println("arr = " + Arrays.toString(arr));
    }

    public static void qucik(int[] arr, int left, int right) {
        if (left < right) {
            int pat = parartion(arr, left, right);
            qucik(arr, left, pat);
            qucik(arr, pat + 1, right);
        }
    }

    public static int parartion(int[] arr, int low, int high) {
        int temp = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= temp) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= temp) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[high] = temp;
        return high;
    }
}
