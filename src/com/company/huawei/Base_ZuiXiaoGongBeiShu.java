package com.company.huawei;

public class Base_ZuiXiaoGongBeiShu {
    public static void main(String[] args) {

    }

    public static int base1(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return base1(b, a % b);
        }
    }

    public static int base2(int a, int b) {
        int c = base1(a, b);
        return a * b / c;
    }
}
