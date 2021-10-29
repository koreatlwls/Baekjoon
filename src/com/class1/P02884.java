package com.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P02884 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int hour = Integer.parseInt(stringTokenizer.nextToken());
        int minute = Integer.parseInt(stringTokenizer.nextToken());

        if (hour > 0) {
            if (minute >= 45) {
                minute -= 45;
            } else {
                hour -= 1;
                minute = minute + 60 - 45;
            }
        } else {
            if (minute >= 45) {
                minute -= 45;
            } else {
                hour = 23;
                minute = minute + 60 - 45;
            }
        }
        System.out.printf("%d %d \n", hour, minute);
    }
}
