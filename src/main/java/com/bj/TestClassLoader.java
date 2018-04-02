package com.bj;

public class TestClassLoader {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 16, 45, 90};
        int re = erfenfa(arr, 0, arr.length - 1, 3);
        System.out.println("re = " + re);
    }

    //    public static void find(int[] arr, int left, int right, int result) {
//        int mid = (left + right) / 2;
//        if (arr[mid] == result) {
//            System.out.println("mid = " + mid);
//            return;
//        }
//        if (arr[mid] <= result) {
//            find(arr, mid + 1, right, result);
//        } else {
//            find(arr, left, mid, result);
//        }
//    }
    public static int erfenfa(int[] arr, int L, int R, int b) {
        int result = -1;
        if (L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] == b) {
                return arr[mid];
            } else if (arr[mid] > b) {
                result = erfenfa(arr, L, mid - 1, b);
            } else {
                result = erfenfa(arr, mid + 1, R, b);
            }

        }
        if (-1 != result) {
            return result;
        } else {
            return -1;
        }
    }

}
