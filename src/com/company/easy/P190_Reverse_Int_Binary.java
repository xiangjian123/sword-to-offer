package com.company.easy;

import java.util.Arrays;

public class P190_Reverse_Int_Binary {
    public static void main(String[] args) {
        int n = -3;
        System.out.println(reverseBits(n));
    }

    public static int reverseBits(int n) {
        int[] arr = new int[32];
        for (int i = 0; i < 32; i++) {
//            arr[i] = (n & 1 << (31 - i)) >> (31 - i);
            int temp = n & 1 << (31 - i);
            arr[i] = temp > 0 ? 1 : 0;
        }


        System.out.println(Arrays.toString(arr));

        int[] arr1 = new int[32];
        for (int i = 0; i < 32; i++) {
            arr1[i] = arr[31 - i];
        }

        System.out.println(Arrays.toString(arr1));

        int index = 1;
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            sum += index * arr1[31 - i];
            index = index << 1;
        }

        return sum;
    }
}
