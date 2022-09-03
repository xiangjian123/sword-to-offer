package com.company.normal;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 *
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/isomorphic-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P205_Same_Construct_String {

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (!map.containsKey(c1)) {
                map.put(c1, c2);
            } else {
                char c3 = map.get(c1);
                if (c2 != c3) {
                    return false;
                }
            }
        }

        // check target same
        int len1 = map.keySet().size();
        int len2 = ((Set)map.values()).size();
        if (len1 != len2) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
