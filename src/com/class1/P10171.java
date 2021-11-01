package com.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10171 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        sb.append("\\    /\\").append("\n").append(" )  ( ')").append("\n").append("(  /  )").append("\n").append(" \\(__)|").append("\n");
        System.out.print(sb);
    }
}
