package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14430 {

    static int N, M;
    static int[][] map;
    static int[][] dp;
    static int[] dr = {0, -1};
    static int[] dc = {-1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = map[0][0];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < 2; k++) {
                    int nextRow = i + dr[k];
                    int nextCol = j + dc[k];

                    if(nextRow <0 || nextRow >=N || nextCol <0 || nextCol >=M)continue;

                    dp[i][j] = Math.max(dp[i][j], dp[nextRow][nextCol] + map[i][j]);
                }
            }
        }

        System.out.print(dp[N-1][M-1]);
    }
}
