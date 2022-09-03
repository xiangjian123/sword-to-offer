package com.company.swordoffer;

import java.util.Arrays;

public class P33_Binary_Tree_Post_Order {
    public static void main(String[] args) {
        int[] arr = {4,8,6,12,16,14,10};
        int[] arr2 = {1,2,5,10,6,9,4,3};
        int[] arr3 = {5,4,3,2,1};
        int[] arr4 = {1,2,3,4,5};
        System.out.println(verifyPostorder(arr4));
    }

    public static boolean verifyPostorder(int[] postorder) {
        int len = postorder.length;
        if (len == 0) {
            return false;
        }

        System.out.println(Arrays.toString(postorder));
        int root = postorder[len - 1];
        System.out.println("root: " + root);

        int index = 0;
        boolean flag = false;
        for (int i = 0; i < len - 1; i++) {
            if (postorder[i] > root) {
                index = i;
                flag = true;
                break;
            }
        }

        if (flag) {
            for (int i = index + 1; i < len - 1; i++) {
                if (postorder[i] < root) {
                    System.out.println(i);
                    System.out.println(index);
                    return false;
                }
            }
        }

        boolean flag1 = true;
        boolean flag2 = true;

        if (index != 0) {
            int[] postleft = Arrays.copyOfRange(postorder, 0, index);
            flag1 = verifyPostorder(postleft);
        }
        if (index != len - 1) {
            int[] postright = Arrays.copyOfRange(postorder, index, len - 1);
            flag2 = verifyPostorder(postright);
        }

        return flag1 && flag2;
    }
}
