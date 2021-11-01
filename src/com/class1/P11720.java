package com.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int result = 0;

        for (int i = 0; i < num; i++) {
            result += str.charAt(i) - '0';
        }
        System.out.print(result);
    }
}
