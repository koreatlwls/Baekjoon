package com.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P02908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuffer num1, num2;
        int reverseNum1, reverseNum2;

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        num1 = new StringBuffer(stringTokenizer.nextToken());
        num2 = new StringBuffer(stringTokenizer.nextToken());

        reverseNum1 = Integer.parseInt(num1.reverse().toString());
        reverseNum2 = Integer.parseInt(num2.reverse().toString());

        if (reverseNum1 > reverseNum2)
            System.out.print(reverseNum1);
        else
            System.out.print(reverseNum2);
    }
}