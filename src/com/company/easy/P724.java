package com.company.easy;

import java.util.Arrays;

/**
 *
 * 给你一个整数数组 nums ，请计算数组的 中心下标 。
 *
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 *
 * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
 *
 * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-pivot-index
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P724 {
    public static void main(String[] args) {
        int[] a = {1,7,3,6,5,6};

        System.out.println(pivotIndex(a));

    }

    public static int pivotIndex(int[] nums) {
        // 构造和数组s1,s1
        // s1为从左向右的和数组
        // s2为从右向左的和数组
        // 双向同步遍历，找到第一个和相同的下标，即为所求内容。如果未找到，返回-1

        int len = nums.length;
        int[] s1 = new int[len];
        int[] s2 = new int[len];

        int temp1 = 0;
        int temp2 = 0;

        s1[0] = 0;
        s2[len - 1] = 0;

        for (int i = 1; i < len; i++) {
            temp1 += nums[i - 1];
            s1[i] = temp1;
        }

        for (int i = len - 2; i >= 0; i--) {
            temp2 += nums[i + 1];
            s2[i] = temp2;
        }

        for (int i = 0; i < len; i++) {
            if (s1[i] == s2[i]) {
                return i;
            }
        }

        return -1;
    }
}
