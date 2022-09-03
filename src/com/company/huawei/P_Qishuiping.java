package com.company.huawei;

import java.io.*;

public class P_Qishuiping {
    public static void  main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = null;
        while (!(str = br.readLine()).equals("0")) {
            int num = Integer.parseInt(str);
            int num1 = getNumber(num);
            bw.write(num1 + "\n");
            bw.flush();
        }

    }

    private static int getNumber(int num) {
        int count = 0;
        count += num / 3;
        int less = num % 3 + count;
        if (less == 0) {
            return count;
        } else if (less == 1) {
            return count;
        } else if (less == 2) {
            return count + 1;
        } else {
            return count + getNumber(less);
        }
    }
}
