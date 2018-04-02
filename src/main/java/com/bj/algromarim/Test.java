package com.bj.algromarim;

import java.sql.Date;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;

public class Test {
    private static String DiffDate = "2005-01-01";
    private static long IdSeed = 0;

    static {

    }
    //最大连续子数组的和
    public static void main(String[] args) {
    }

    public static int sumOfLargestContigousSubarray(int[] array) {
        if (null == array || array.length < 1) {
            return 0;
        }
        int summax = 0;
        int[] sum = new int[array.length];
        sum[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            if (sum[i - 1] + array[i] > array[i]) {
                sum[i] = sum[i - 1] + array[i];
            } else {
                sum[i] = array[i];
            }
        }

        for (int i = 0; i < sum.length; i++) {
            if (sum[i] > summax) {
                summax = sum[i];
            }
            System.out.println("sum = " + sum[i]);
        }

        return summax;
    }
}
