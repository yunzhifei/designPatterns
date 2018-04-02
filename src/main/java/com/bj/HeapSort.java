package com.bj;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 16, 45, 90};
        heapSort(arr);
        System.out.println("arr.toString() = " + Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {
        //建立大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            //从最小的非叶子节点开始调整，直到调整完毕
            ajustHeap(arr, i, arr.length);
        }
        //交换堆顶和最后一个元素然后从新调整
        for (int j = arr.length - 1; j > 0; j--) {
            swap(arr, 0, j);
            ajustHeap(arr, 0, j);
        }

    }

    public static void swap(int[] arr, int left, int right) {
        arr[left] = arr[left] ^ arr[right];
        arr[right] = arr[left] ^ arr[right];
        arr[left] = arr[left] ^ arr[right];
    }

    public static void ajustHeap(int[] arr, int i, int right) {

        for (int k = 2 * i + 1; k < right; k = 2 * k + 1) {
            //判断左叶子大还是右叶子大
            if (k < right - 1 && arr[k + 1] > arr[k]) {
                //如果右叶子大就把大的叶子下标记录下来
                k++;
            }
            if (arr[k] > arr[i]) {
                //叶子大于根，交换根和大的叶子节点
                swap(arr, i, k);
                //交换以后叶子成了新的二叉树的根
                // ，新的二叉树需要调整，下标交换
                i = k;
            } else {
                break;
            }
        }
    }
}
