package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P524 {
    public static void main(String[] args) {
        String s = "abpcplea";
        String[] arr = {"ale","apple","monkey","plea"};
        List<String> dic = Arrays.asList(arr);
        System.out.println(findLongestWord(s, dic));
    }

    public static String findLongestWord(String s, List<String> dictionary) {
        String result = "";
        for (String str : dictionary) {
            if (isSubSeq(s, str)) {
                if (str.length() > result.length()) {
                    result = str;
                } else if (str.length() == result.length()) {
                    if (str.compareTo(result) < 0) {
                        result = str;
                    }
                }
            }
        }

        return result;
    }


    private static boolean isSubSeq(String s1, String s2) {
        if (s2.length() > s1.length()) {
            return false;
        }

        int i = 0, j = 0;
        for (; i < s1.length() && j < s2.length(); ) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }

        if (j == s2.length()) {
            return true;
        } else {
            return false;
        }
    }
}
