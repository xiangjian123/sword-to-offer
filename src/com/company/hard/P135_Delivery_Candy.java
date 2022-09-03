package com.company.hard;

import java.util.Arrays;

/**
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 *
 * 你需要按照以下要求，给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：ratings = [1,0,2]
 * 输出：5
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
 * 示例 2：
 *
 * 输入：ratings = [1,2,2]
 * 输出：4
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
 *      第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/candy
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P135_Delivery_Candy {
    public static void main(String[] args) {
        int[] arr1 = {1,0,2};
        int[] arr2 = {1,2,2};
        int[] arr3 = {1,3,2,2,1};
        System.out.println(candy(arr3));
    }

    public static int candy(int[] ratings) {
        /*
          思路2：动态规划
          先考虑只有一个孩子，则直接发1个结束。
          如果有2个孩子，如果第二个孩子比第一个分数低，则数量为比第一个少1个。如果为0，则为1，前一个均多1个。
          如果第二个和第一个一样；则数量和第一个相同
          如果第二个比第一个搞，则数量为比第一个多1个。
          每个孩子的糖果数，只需要和前一个孩子比较。

          s(i) =
            if i - 1 == i: s(i)
        */

        int len = ratings.length;
        int[] arr = new int[len];

        arr[0] = 1;

        for (int i = 1; i < len; i++) {
            if (ratings[i] == ratings[i - 1]) {
                arr[i] = 1;
            } else if (ratings[i] > ratings[i - 1]) {
                arr[i] = arr[i - 1] + 1;
            } else {
                arr[i] = 1;
                // i - 1必须处理，唯一需要考虑是否j继续向前
                arr[i - 1] += 1;
                for (int j = i - 1; j > 0; j--) {
                    if (ratings[j] == ratings[j - 1]) {
                        break;
                    } else if (ratings[j] > ratings[j - 1]) {
                        break;
                    } else {
                        ;
                    }
                }
            }
        }

        System.out.println(Arrays.toString(arr));
        int result = 0;
        for (int i = 0; i < len; i++) {
            result += arr[i];
        }

        return result;
    }

}
