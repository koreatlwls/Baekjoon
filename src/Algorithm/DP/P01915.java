package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P01915 {

    static int N, M, max;
    static int[][] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = input.charAt(j) - '0';
                dp[i][j] = arr[i][j];
                if (i >= 1 && j >= 1) {
                    if (dp[i - 1][j] > 0 && dp[i - 1][j - 1] > 0 && dp[i][j - 1] > 0 && dp[i][j] > 0) {
                        int min = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
                        dp[i][j] = min + 1;
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        System.out.print(max * max);
    }
}