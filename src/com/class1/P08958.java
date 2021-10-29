package com.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P08958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int i, j;
        int num = Integer.parseInt(br.readLine());
        String str;
        int result = 0;
        int initScore = 1;

        for (i = 0; i < num; i++) {
            str = br.readLine();
            for (j = 0; j < str.length(); j++) {
                if (str.charAt(j) == 'O') {
                    result += initScore;
                    initScore++;
                } else {
                    initScore = 1;
                }
            }
            sb.append(result).append("\n");
            result = 0;
            initScore = 1;
        }
        System.out.print(sb);
    }
}
