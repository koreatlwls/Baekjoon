package com.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10172 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        sb.append("|\\_/|").append("\n").append("|q p|   /}").append("\n").append("( 0 )\"\"\"\\").append("\n").append("|\"^\"`    |").append("\n").append("||_/=\\\\__|").append("\n");
        System.out.print(sb);
    }
}
