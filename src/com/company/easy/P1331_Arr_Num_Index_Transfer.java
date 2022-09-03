package com.company.easy;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 给你一个整数数组 arr ，请你将数组中的每个元素替换为它们排序后的序号。
 *
 * 序号代表了一个元素有多大。序号编号的规则如下：
 *
 * 序号从 1 开始编号。
 * 一个元素越大，那么序号越大。如果两个元素相等，那么它们的序号相同。
 * 每个数字的序号都应该尽可能地小。
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [40,10,20,30]
 * 输出：[4,1,2,3]
 * 解释：40 是最大的元素。 10 是最小的元素。 20 是第二小的数字。 30 是第三小的数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/rank-transform-of-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P1331_Arr_Num_Index_Transfer {

    public static void main(String[] args) {
        int[] arr1 = {37,12,28,9,100,56,80,5,12};
        int[] ret = arrayRankTransform(arr1);
        System.out.println(Arrays.toString(ret));

    }

    public static int[] arrayRankTransform(int[] arr) {
        // 排序，使用哈希表记录位置，每个数字只记录一次。遍历原数组，读哈希表写新数组

        // 选择排序，但是不移动位置，计算数量，index每个数字 + 1


        int len = arr.length;
        if (len == 0) {
            return new int[]{0};
        }
        if (len == 1) {
            return new int[]{1};
        }

        int[] ret = new int[len];
        int index = 1;
        int count = 0;
        while (count < len) {
            int min = Integer.MAX_VALUE;
            // 寻找最小的数，然后遍历数字，将最小值记录index为1，可以统计已经修改的数字
            for (int j = 0; j < len; j++) {
                if (ret[j] == 0 && arr[j] < min) {
                    min = arr[j];
                }
            }

            for (int j = 0; j < len; j++) {
                if (arr[j] == min && ret[j] == 0) {
                    ret[j] = index;
                    count++;
                }
            }
            index++;
        }

        return ret;

//        int[] arr2 = new int[len];
//        for (int i = 0; i < len; i++) {
//            arr2[i] = arr[i];
//        }
//
//        Arrays.sort(arr2);
//        int[] ret = new int[len];
//
//        Map<Integer, Integer> map = new HashMap<>();
//
//        for (int i = 0; i < len; i++) {
//            map.putIfAbsent(arr2[i], i);
//        }
//
//        for (int i = 0; i < len; i++) {
//            ret[i] = map.get(arr[i]) + 1;
//        }
//
//        return ret;
    }
}
