package com.company.hard;

import java.util.ArrayList;
import java.util.List;

public class P123_Bus_Stock_Max_Twice {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {3,3,5,0,0,3,1,4};
        int[] arr3 = {7,6,4,3,1};
        int[] arr4 = {1};
        System.out.println(maxProfit(arr1));
        System.out.println(maxProfit(arr2));
        System.out.println(maxProfit(arr3));
        System.out.println(maxProfit(arr4));
    }

    public static int maxProfit(int[] prices) {
        List<Integer> list = new ArrayList<>();

        int n = prices.length;
        int start = 0;
        while (start < n) {
            int s2 = start + 1;
            while (s2 < n) {
                if (prices[s2] >= prices[s2 - 1]) {
                    s2++;
                } else {
                    // index s2 - 1 结束上升，
                    // start = s1, finish = s2 - 1
                    list.add(prices[s2 - 1] - prices[start]);
                    break;
                }
            }
            if (s2 == n) {
                list.add(prices[s2 - 1] - prices[start]);
            }
            start = s2;
        }

        if (list.size() == 0) {
            return 0;
        }

        if (list.size() == 1) {
            return list.get(0);
        }

        // 求list中的2个最大值
        int num = list.size();
        int[] arr1 = new int[num];

        int firstIndex = 0;
        int firstMax = list.get(0);
        for (int i = 1; i < num; i++) {
            if (list.get(i) > firstMax) {
                firstMax = list.get(i);
                firstIndex = i;
            }
        }

        list.remove(firstIndex);

        int secondIndex = 0;
        int secondMax = list.get(0);
        for (int i = 1; i < num - 1; i++) {
            if (list.get(i) > secondMax) {
                secondMax = list.get(i);
                secondIndex = i;
            }
        }

        return firstMax + secondMax;
    }

}
