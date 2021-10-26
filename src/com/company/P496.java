package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * 496. 下一个更大元素 I
 *
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
 *
 * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
 *
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 *     对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
 *     对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
 *     对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 * 示例 2:
 *
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出: [3,-1]
 * 解释:
 *     对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
 *     对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 *  
 *
 * 提示：
 *
 * 1 <= nums1.length <= nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 104
 * nums1和nums2中所有整数 互不相同
 * nums1 中的所有整数同样出现在 nums2 中
 *  
 *
 * 进阶：你可以设计一个时间复杂度为 O(nums1.length + nums2.length) 的解决方案吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P496 {
    public static void main(String[] args) {
        int[] a1 = {4,1,2};
        int[] a2 = {1,3,4,2};

        int[] a3 = {2,4};
        int[] a4 = {1,2,3,4};

        int[] a5 = {1,3,5,2,4};
        int[] a6 = {6,5,4,3,2,1,7};

        int[] r1 = nextGreaterElement2(a5, a6);
        System.out.println(Arrays.toString(r1));
    }

    // m * n
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] arr = new int[len1];
        for (int i = 0; i < len1; i++) {
            arr[i] = -1;
        }

        for (int i = 0; i < len1; i++) {
            int index = -1;
            for (int j = 0; j < len2; j++) {
                if (nums1[i] == nums2[j]) {
                    index = j;
                    break;
                }
            }
            if (index != -1) {
                for (int j = index + 1; j < len2; j++) {
                    if (nums1[i] < nums2[j]) {
                        arr[i] = nums2[j];
                        break;
                    }
                }
            }
        }

        return arr;
    }


    // m + n
    public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] arr = new int[len1];
        for (int i = 0; i < len1; i++) {
            arr[i] = -1;
        }

        // 使用哈希表+栈方式，遍历nums2，计算出每个树的下一个大值，保存在哈希表中，然后遍历nums1查表
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len2; i++) {
            if (stack.size() == 0) {
                stack.push(nums2[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                    map.put(stack.pop(), nums2[i]);
                }
                stack.push(nums2[i]);
            }

            if (i == len2 - 1) {
                map.put(nums2[i], -1);
                stack.pop();
            } else if (nums2[i] < nums2[i + 1]) {
                map.put(nums2[i], nums2[i + 1]);
                stack.pop();
            }
        }

        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        for (int i = 0; i < len1; i++) {
            arr[i] = map.get(nums1[i]);
        }

        return arr;
    }
}
