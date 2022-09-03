package com.company.swordoffer;

public class P009_Muitl_Less_K {
    public static void main(String[] args) {
        int[] a1 = {10,5,2,6};
        int k1 = 100;
        int[] a2 = {1,2,3};
        int k2 = 0;

        System.out.println(numSubarrayProductLessThanK(a1, k1));

    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int ret = 0;

        int prod = 1;
        int i = 0;
        for (int j = 0; j < n; j++) {
            prod *= nums[j];
            while (i <= j && prod >= k) {
                prod /= nums[i];
                i++;
            }

            ret += j - i + 1;
        }

        return ret;

    }
}
