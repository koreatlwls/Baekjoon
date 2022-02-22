package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P03067 {

    static int N, M;
    static int[] coins, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            coins = new int[N];
            dp = new int[10001];

            for (int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            M = Integer.parseInt(br.readLine());

            dp[0] = 1;
            for(int i=0;i<N;i++){
                for(int j=coins[i];j<=M;j++){
                    dp[j] += dp[j - coins[i]];
                }
            }

            sb.append(dp[M]).append("\n");
        }

        System.out.print(sb);
    }
}
