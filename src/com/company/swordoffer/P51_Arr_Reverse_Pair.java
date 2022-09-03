package com.company.swordoffer;

public class P51_Arr_Reverse_Pair {
    public static void main(String[] args) {
    }

    public static int reversePairs(int[] nums) {
        // 暴力法：n^2

        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            int temp = nums[i];
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < temp) {
                    count++;
                }
            }
        }

        return count;
    }
}
