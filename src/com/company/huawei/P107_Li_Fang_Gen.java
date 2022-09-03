package com.company.huawei;

import java.io.IOException;
import java.util.*;


public class P107_Li_Fang_Gen {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        double value = scanner.nextDouble();
        double max = value / 3.0;
        double temp = 0.0;
        for (double i = 0; i <= max; i += 0.1) {
            double ret = i * i * i;
            if (value - ret > 0.00000001 ) {
                temp = i;
            }
        }

        System.out.println(String.format("%.1f", temp));
    }
}



