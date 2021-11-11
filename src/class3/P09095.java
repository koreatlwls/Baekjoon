package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P09095 {

    static int[] dp = new int[11];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int result = DP(n);
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }

    static int DP(int n) {
        if (dp[n] == 0 && n > 2) {
            dp[n] = DP(n - 1) + DP(n - 2) + dp[n - 3];
        }
        return dp[n];
    }
}
