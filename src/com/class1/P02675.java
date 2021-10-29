package com.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P02675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int i, j, k;
        int count;
        String str;
        int num = Integer.parseInt(br.readLine());

        for (i = 0; i < num; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            count = Integer.parseInt(stringTokenizer.nextToken());
            str = stringTokenizer.nextToken();
            for (j = 0; j < str.length(); j++) {
                for (k = 0; k < count; k++) {
                    sb.append(str.charAt(j));
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
