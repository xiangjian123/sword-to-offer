package com.company.swordoffer;

public class P008_Sum_Larger_Than_Target_Min_Len {
    public static void main(String[] args) {
        int[] arr1 = {2,3,1,2,4,3};
        int target1 = 7;
        int[] arr2 = {1,2,3,4,5};
        int target2 = 15;

        System.out.println(min2(target1, arr1));
    }

    public static int min2(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }


        int sum = 0;
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;

        while (right < n) {
            sum += nums[right];
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
