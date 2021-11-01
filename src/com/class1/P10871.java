package com.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer stringTokenizer1 = new StringTokenizer(br.readLine());
        StringTokenizer stringTokenizer2 = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(stringTokenizer1.nextToken());
        int x = Integer.parseInt(stringTokenizer1.nextToken());
        int result = 0;

        for (int i = 0; i < num; i++) {
            result = Integer.parseInt(stringTokenizer2.nextToken());
            if (x > result)
                sb.append(result + " ");
        }
        System.out.print(sb);
    }
}
