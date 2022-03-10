package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P13398 {

    static int N;
    static int[] input;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        input = new int[N];
        dp = new int[N][2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][0] = input[0];
        dp[0][1] = 0;

        int answer = input[0];
        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.max(input[i], dp[i - 1][0] + input[i]);
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + input[i]);

            answer = Math.max(answer, Math.max(dp[i][0], dp[i][1]));
        }

        System.out.print(answer);
    }
}
