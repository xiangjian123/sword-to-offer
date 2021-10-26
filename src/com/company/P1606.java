package com.company;

import java.util.Arrays;

public class P1606 {
    public static void main(String[] args) {
        int[] a = {1,3,15,11,2};
        int[] b = {23,127,235,19,8};
        int result = smallestDifference(a, b);
        System.out.println(result);
    }

    public static int smallestDifference(int[] a, int[] b) {
        // 转long数组，排序，记录min，时间复杂度ON平方
        long[] al = new long[a.length];
        long[] bl = new long[b.length];

        for (int i = 0; i < a.length; i++) {
            al[i] = a[i];
        }

        for (int i = 0; i < b.length; i++) {
            bl[i] = b[i];
        }

        Arrays.sort(al);
        Arrays.sort(bl);

        long min = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while (i < al.length && j < bl.length) {
            if (al[i] != bl[j]) {
                min = Math.min(min, Math.abs(al[i] - bl[j]));
                if (al[i] > bl[j]) {
                    j++;
                } else {
                    i++;
                }
            } else {
                return 0;
            }
        }

//
//        for (int i = 0; i < al.length; i++) {
//            for (int j = 0; j < bl.length; j++) {
//                long diff = Math.abs(al[i] - bl[j]);
//                if (diff < min) {
//                    min = diff;
//                }
//            }
//        }

        return Math.abs((int)min);
    }
}
