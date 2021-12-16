package Algorithm.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P02217 {

    static int n;
    static int[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        input = new int[n];
        for(int i=0;i<n;i++){
            input[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(input);

        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int val = input[i] * (n-i);
            max = Math.max(max,val);
        }

        System.out.print(max);
    }
}
