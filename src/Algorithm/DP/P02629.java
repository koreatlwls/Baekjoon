package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P02629 {

    static int N, M;
    static int question, max = 15000;
    static int[] arr;
    static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        dp = new boolean[31][max + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        find_dp(0, 0);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            question = Integer.parseInt(st.nextToken());
            if (question > 15000) sb.append("N ");
            else sb.append(dp[N][question] ? "Y " : "N ");
        }

        System.out.print(sb);
    }

    static void find_dp(int idx, int weight) {
        if (dp[idx][weight]) return;
        dp[idx][weight] = true;
        if (idx == N) return;

        find_dp(idx + 1, weight + arr[idx + 1]);
        find_dp(idx + 1, weight);
        find_dp(idx + 1, Math.abs(weight - arr[idx + 1]));
    }
}