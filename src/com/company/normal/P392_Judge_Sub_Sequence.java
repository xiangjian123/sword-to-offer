package com.company.normal;


/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 进阶：
 *
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 *
 * 致谢：
 *
 * 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/is-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P392_Judge_Sub_Sequence {
    public static void main(String[] args) {

    }

    public boolean isSubsequence(String s, String t) {
        // 原始问题：思路1：两个指针，从头扫描。
        // s与t相同，指针都加1.
        // s与t不同，t加1
        // 最后判定s指针是否结束


        // 进阶：大量S下如何修改？

        int len1 = s.length();
        int len2 = t.length();
        if (len1 == 0) {
            return true;
        }

        if (len1 > len2) {
            return false;
        }

        int i = 0;
        int j = 0;
        while (i < len1 && j < len2) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }

        return i == len1;

    }
}
