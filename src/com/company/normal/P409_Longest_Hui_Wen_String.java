package com.company.normal;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class P409_Longest_Hui_Wen_String {
    public static void main(String[] args) {
        String s1 = "abccccdd";
        System.out.println(longestPalindrome(s1));
    }

    public static int longestPalindrome(String s) {
        // 思路：回文只有两种形式，aa，aba.
        // 统计每个字符出现的次数，只能有N对字符和1个或者0个字符组成

//        Map<Character, Integer> map = new HashMap<>();
//        int len = s.length();
//        for (int i = 0; i < len; i++) {
//            if (!map.containsKey(s.charAt(i))) {
//                map.put(s.charAt(i), 1);
//            } else {
//                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
//            }
//        }
//
//        AtomicInteger count = new AtomicInteger();
//        AtomicBoolean oddFlag = new AtomicBoolean(false);
//        map.forEach((key, value) -> {
//            if (value % 2 == 0) {
//                count.addAndGet(value);
//            } else {
//                count.addAndGet(value - 1);
//                oddFlag.set(true);
//            }
//        });
//
//        if (oddFlag.get()) {
//            count.addAndGet(1);
//        }
//
//        return count.get();

        int[] count = new int[128];
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            char c = s.charAt(i);
            count[c]++;
        }

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }
}
