package com.company.huawei;

import java.io.*;

public class P_String_Split_With_8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        while ((str = br.readLine()) != null) {
            int len = str.length();
            int append = 0;
            if (len % 8 != 0) {
                append = 8 - len % 8;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < append; i++) {
                sb.append('0');
            }
            str = str + sb.toString();
            for (int i = 0; i < str.length(); i += 8) {
                bw.write(str.substring(i, i + 8));
                bw.flush();
            }
        }
    }
}
