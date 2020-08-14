package com.company;

import java.util.Arrays;

/**
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串
 */
public class S0102 {
    public static void main(String[] args) {
        ;
    }

    public boolean CheckPermutation(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        Arrays.sort(arr1);

        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

    public boolean CheckPermutation1(String s1, String s2) {
        int[] arr = new int[26];
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 != len2) {
            return false;
        }

        for (int i = 0; i< len1; i++) {
            arr[s1.charAt(i) - 'a']++;
            arr[s2.charAt(i) - 'a']--;
        }

        for (int i = 0 ;i < 26; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
