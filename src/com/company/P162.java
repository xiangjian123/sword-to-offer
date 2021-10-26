package com.company;

import java.util.Arrays;

public class P162 {

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,3};
        int[] arr2 = {1,2,1,3,5,6,4};
        int[] arr3 = {1};
        int[] arr4 = {1,2};
        System.out.println(findPeakElement(arr1));
        //System.out.println(findPeakElement(arr2));
        //System.out.println(findPeakElement(arr3));
        //System.out.println(findPeakElement(arr4));
    }

    public static int findPeakElement(int[] nums) {
        // 递归。取中间值，比较是否大于两边，是则返回，不是则比较两个部分。
        // 注意在分开的时候，注意头尾的处理
        // 剩余大小只有1的时候，停止处理
        if (nums.length <= 1) {
            return 0;
        }

        if (nums.length == 2) {
            if (nums[0] > nums[1]) {
                return 0;
            } else if (nums[0] < nums[1]) {
                return 1;
            } else {
                return 0;
            }
        }

        if (nums[0] > nums[1]) {
            return 0;
        }

        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }

        int result = find(nums, 0 , nums.length);
        return  result;

    }

    public static int find(int[] nums, int start ,int end) {
        int len = nums.length;
        if (len <= 2) {
            return 0;
        }

        if (len == 3) {
            if (nums[start + 1] > nums[start] && nums[start + 1] > nums[start + 2]) {
                return start + 1;
            }
        }

        int mid = (start + end) / 2;
        if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
            return mid;
        } else {
            int[] left = Arrays.copyOfRange(nums, start, mid + 2);
            int[] right = Arrays.copyOfRange(nums, mid - 1, end + 1);
            int lr = find(left, start, mid + 1);
            if (lr > 0) {
                return lr;
            }

            int rr = find(right, mid - 1, end);
            if (rr > 0) {
                return rr;
            }
        }

        return 0;
    }
}
