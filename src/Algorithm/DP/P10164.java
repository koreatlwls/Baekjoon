package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10164 {
    static long[][] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int cnt = 1;
        int kx = -1, ky = -1;

        dp = new long[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (cnt == K) {
                    kx = i;
                    ky = j;
                }

                cnt++;
                dp[i][j] = -1;
            }
        }

        if (K == 0) {
           System.out.print(recursion(1, 1, N, M) + "\n");
        } else {
            long result = recursion(1, 1, kx, ky) * recursion(kx, ky, N, M);
            System.out.print(result + "\n");
        }
    }

    static long recursion(int x, int y, int endX, int endY) {
        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        if (x == endX && y == endY) {
            return 1;
        }

        dp[x][y] = 0;

        if (x + 1 >= 1 && y >= 1 && x + 1 <= endX && y <= endY) {
            dp[x][y] += recursion(x + 1, y, endX, endY);
        }

        if (x >= 1 && y + 1 >= 1 && x <= endX && y + 1 <= endY) {
            dp[x][y] += recursion(x, y + 1, endX, endY);
        }

        return dp[x][y];
    }

}