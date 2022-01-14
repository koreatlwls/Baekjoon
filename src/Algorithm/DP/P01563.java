package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01563 {

    static int n;
    static int[][][] dp;
    static final int INF = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        dp = new int[n + 1][2][3];

        dp[1][0][0] = 1;
        dp[1][0][1] = 1;
        dp[1][1][0] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i][0][0] = (dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2]) % INF;
            dp[i][0][1] = dp[i - 1][0][0] % INF;
            dp[i][0][2] = dp[i - 1][0][1] % INF;
            dp[i][1][0] = (dp[i-1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2] + dp[i - 1][1][0] + dp[i - 1][1][1] + dp[i - 1][1][2]) % INF;
            dp[i][1][1] = dp[i - 1][1][0] % INF;
            dp[i][1][2] = dp[i - 1][1][1] % INF;
        }

        int ans = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                ans += dp[n][i][j];
            }
        }

        System.out.print(ans % INF);
    }
}
