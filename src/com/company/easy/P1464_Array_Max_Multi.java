package com.company.easy;

public class P1464_Array_Max_Multi {
    public static void main(String[] args) {
        int[] arr1 = {3,4,5,2};
        System.out.println(maxProduct(arr1));
    }

    public static int maxProduct(int[] nums) {
        int n = nums.length;

        int[] flag = new int[n];
        // first first max;
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }

        System.out.println(max);
        System.out.println(index);

        flag[index] = 1;
        int secMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] > secMax && flag[i] != 1) {
                secMax = nums[i];
            }
        }

        System.out.println(secMax);

        return (max - 1) * (secMax - 1);

    }
}
