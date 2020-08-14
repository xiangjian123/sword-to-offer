package com.company;

/**
    判定字符串s中的所有字符都不相同
    不适用额外数据结构加分
    0-len-100

    s = "leetcode" false
    s = "abc" true

    额外数据结构:
    1. set add fail return false
    2. hash >1 return false

    位运算:


    indexOf lastIndexOf:



 */
public class S0101 {
    public static void main(String[] args) {

    }

    public boolean isUnique1(String astr) {
        int x = 0;
        char[] arr = astr.toCharArray();
        for (char c : arr) {
            if ((x & (1 << (c - 'a'))) != 0) {
                return false;
            } else {
                x |= 1 << (c - 'a');
            }
        }
        return true;
    }

    public boolean isUnique(String astr) {
        int len = astr.length();
        if (len == 0 || len == 1) {
            return true;
        }

        boolean flag = true;
        for (int i = 0, l = len; i < l - 1; i++) {
            if (astr.indexOf(astr.charAt(i)) != astr.lastIndexOf(astr.charAt(i))) {
                flag = false;
            }
        }
        return flag;
    }
}
