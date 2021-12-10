package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10870 {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 4];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        if (n > 2) {
            System.out.print(fibonacci(n));
        } else {
            System.out.print(dp[n]);
        }
    }

    static int fibonacci(int n) {
        if (dp[n] != 0) {
            return dp[n];
        } else {
            return dp[n] = fibonacci(n - 1) + dp[n - 2];
        }
    }
}
