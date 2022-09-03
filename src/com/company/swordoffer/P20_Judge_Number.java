package com.company.swordoffer;

public class P20_Judge_Number {
    public static void main(String[] args) {
        String s = "2e0";
        System.out.println(isNumber(s));
    }

    public static boolean isNumber(String s) {
        if (s == null) {
            return false;
        }

        s = s.trim().toUpperCase();

        // 判断是否有e，并且只有0个或者1个
        // 如果存在e，则前面为小数或者整数，后面为整数
        // 如果不存在e，则前面为小数或者整数.
        if (s.indexOf('E') == -1) {
            // 不存在e，判定整数或者小数

            return judgeFloat(s) || judgeInt(s);
        }

        // 存在多个E
        if (s.indexOf('E') != s.lastIndexOf('E')) {
            return false;
        }

        int len = s.length();
        int index = s.indexOf('E');
        if (index == len - 1) {
            // E后面无内容
            return false;
        }

        String first = s.substring(0, index);
        String second = s.substring(index + 1, len);

        return (judgeFloat(first) || judgeInt(first)) && judgeInt(second);
    }

    private static boolean judgeFloat(String s) {
        String str = s;
        if (s.startsWith("+") || s.startsWith("-")) {
            str = s.substring(1);
        }

        if (s.length() < 1) {
            return false;
        }

        if (str.indexOf('.') != str.lastIndexOf('.')) {
            return false;
        }

        int index = str.indexOf('.');
        int len = str.length();
        // 一个点开头，后面应该全是数字
        if (index == 0) {
            if (len == 1) {
                return false;
            }
            for (int i = 1; i < len; i++) {
                if (!Character.isDigit(str.charAt(i))) {
                    return false;
                }
            }
        } else if (index == len - 1) {
            // 最后一个是点，前面全是数字
            for (int i = 0; i < len - 1; i++) {
                if (!Character.isDigit(str.charAt(i))) {
                    return false;
                }
            }
        } else {
            // 点在中间，则判断前后是否为数字
            for (int i = 0; i < index; i++) {
                if (!Character.isDigit(str.charAt(i))) {
                    return false;
                }
            }
            for (int i = index + 1; i < len; i++) {
                if (!Character.isDigit(str.charAt(i))) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean judgeInt(String s) {
        String str = s;
        if (s.startsWith("+") || s.startsWith("-")) {
            str = s.substring(1);
        }

        if (s.length() < 1) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}
