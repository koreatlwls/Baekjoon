package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        if (N >= 4) {
            for (int i = 4; i <= N; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
                dp[i] %=10007;
            }
        }

        System.out.print(dp[N]);
    }
}
