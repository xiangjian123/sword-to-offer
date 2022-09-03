package com.company.normal;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P78_Sub_Set {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3};
        List<List<Integer>> r1 = subsets(arr1);
        System.out.println(r1.toString());
    }

    public static List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return new ArrayList<>();
        }

        // S0
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp2 = new ArrayList<>();
        if (len == 1) {
            result.add(new ArrayList<>());
            temp2.add(nums[0]);
            result.add(temp2);
            return result;
        }

        result.add(new ArrayList<>());
        List<Integer> temp3 = new ArrayList<>();
        temp3.add(nums[0]);
        result.add(temp3);

        System.out.println(result.toString());
        // S1
        int temp = 1;
        while (temp < len) {
            List<List<Integer>> r1 = new ArrayList<>();

            for (List<Integer> res : result) {
                List<Integer> t1 = new ArrayList<>(res);
                t1.add(nums[temp]);
                r1.add(t1);
            }

            result.addAll(r1);

            List<Integer> temp1 = new ArrayList<>();
            temp1.add(nums[temp]);
            result.add(temp1);

            temp++;

            System.out.println(result.toString());
        }

        return result;
    }
}
