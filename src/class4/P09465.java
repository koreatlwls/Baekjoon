package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P09465 {

    static int[][] dp;
    static int[][] sticker;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {

            int n = Integer.parseInt(br.readLine());

            sticker = new int[3][n + 1];
            dp = new int[3][n + 1];

            for (int j = 1; j <= 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= n; k++) {
                    sticker[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            if (n > 2) {
                dp[1][1] = sticker[1][1];
                dp[2][1] = sticker[2][1];
                dp[1][2] = dp[2][1] + sticker[1][2];
                dp[2][2] = dp[1][1] + sticker[2][2];

                for (int j = 3; j <= n; j++) {
                    dp[1][j] = Math.max(dp[2][j - 1] + sticker[1][j], Math.max(dp[1][j - 2], dp[2][j - 2]) + sticker[1][j]);
                    dp[2][j] = Math.max(dp[1][j - 1] + sticker[2][j], Math.max(dp[1][j - 2], dp[2][j - 2]) + sticker[2][j]);
                }
            } else if (n == 2) {
                dp[1][1] = sticker[1][1];
                dp[2][1] = sticker[2][1];
                dp[1][2] = dp[2][1] + sticker[1][2];
                dp[2][2] = dp[1][1] + sticker[2][2];
            } else {
                dp[1][1] = sticker[1][1];
                dp[2][1] = sticker[2][1];
            }

            int result = Math.max(dp[1][n], dp[2][n]);
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }
}
