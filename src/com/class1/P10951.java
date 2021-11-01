package com.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stringTokenizer;

        while (true) {
            try {
                stringTokenizer = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(stringTokenizer.nextToken());
                int b = Integer.parseInt(stringTokenizer.nextToken());
                sb.append(a + b).append("\n");
            } catch (Exception e) {
                break;
            }
        }
        System.out.print(sb);
    }
}
