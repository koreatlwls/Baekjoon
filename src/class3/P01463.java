package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01463 {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        dp = new int[1000000 + 1];
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        System.out.print(DP(N));
    }

    static int DP(int n) {
        if (n > 3 && dp[n] == 0) {
            if (n % 6 == 0) {
                dp[n] = Math.min(DP(n / 2) + 1, DP(n / 3) + 1);
                dp[n] = Math.min(dp[n], DP(n - 1) + 1);
            } else if (n % 2 == 0) {
                dp[n] = Math.min(DP(n / 2) + 1, DP(n - 1) + 1);
            } else if (n % 3 == 0) {
                dp[n] = Math.min(DP(n / 3) + 1, DP(n - 1) + 1);
            } else {
                dp[n] = DP(n - 1) + 1;
            }
        }
        return dp[n];
    }
}
