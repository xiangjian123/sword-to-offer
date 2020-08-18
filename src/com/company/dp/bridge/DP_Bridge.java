package com.company.dp.bridge;


public class DP_Bridge {
    public static void main(String[] args) {
        Implementor imp = new I1();
        A1 a1 = new A1(imp);
        a1.request();
    }
}
