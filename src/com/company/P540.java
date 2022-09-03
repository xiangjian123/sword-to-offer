package com.company;

/**
 * 给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
 *
 * 请你找出并返回只出现一次的那个数。
 *
 * 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums =  [3,3,7,7,10,11,11]
 * 输出: 10
 *  
 *
 * 提示:
 *
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-element-in-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P540 {
    public static void main(String[] args) {
        int[] arr = {1,1,2,3,3,4,4,8,8};
        System.out.println(singleNonDuplicate(arr));

        int[] arr2 = {1,1,2};
        System.out.println(singleNonDuplicate(arr2));


        int[] arr3 = {1,2,2,3,3};
        System.out.println(singleNonDuplicate(arr3));
    }

    public static int singleNonDuplicate(int[] nums) {
        // logn 二分法，有序，注意边界
        // 单个数特征：三个值不相同;相同时，左边两个;不符合时递归查看两边
        // 特征2：双数成对，前面没有单个值时，两个数的位置为 偶数，奇数。
        // 符合特征2时，值在后面，不符合特征2时，值在前面
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (left == right - 1) {
                if (left - 1 >= 0 && nums[left] == nums[left - 1]) {
                    return nums[right];
                } else {
                    return nums[left];
                }
            }

            System.out.println("left " + left + " right " + right + " mid " + mid);
            if (nums[mid - 1] != nums[mid] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            } else if (nums[mid - 1] == nums[mid]) {
                if ((mid - 1) % 2 != 0) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else {
                if ((mid - 1) % 2 == 0) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
        }
        return 0;
    }
}
