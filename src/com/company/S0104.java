package com.company;

/**
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 *
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 *
 * 回文串不一定是字典当中的单词。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-permutation-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路：
 *  回文有两种: aba abba
 *  奇数长度：只有一个字符数量为奇数，其它数量都为偶数
 *  偶数长度：所有字符的数量为偶数
 */
public class S0104 {

    public static void main(String[] args) {

    }

    public boolean canPermutePalindrome(String s) {
        int len = s.length();

        int[] arr = new int[128];
        for (int i = 0; i < 128; i++) {
            arr[i] = 0;
        }

        if (len % 2 == 0) {
            for (int i = 0; i < len; i++) {
                arr[s.charAt(i) - ' ']++;
            }

            for (int i = 0; i < 128; i++) {
                if (arr[i] % 2 != 0) {
                    return false;
                }
            }
            return true;
        } else {
            for (int i = 0; i < len; i++) {
                arr[s.charAt(i) - ' ']++;
            }

            int count = 0;
            for (int i = 0; i < 128; i++) {
                if (arr[i] % 2 != 0) {
                    count += 1;
                }
            }

            if (count != 1) {
                return false;
            }

            return true;

        }
    }
}
