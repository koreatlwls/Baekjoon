package Algorithm.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P01520 {

    static int m, n;
    static int[][] map;
    static int[][] dp;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[m + 1][n + 1];
        dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.print(dfs(1, 1));
    }

    static int dfs(int row, int col) {
        if (row == m && col == n) {
            return 1;
        }

        if (dp[row][col] != -1) {
            return dp[row][col];
        } else {
            dp[row][col] = 0;
            for (int i = 0; i < 4; i++) {
                int nextRow = row + dr[i];
                int nextCol = col + dc[i];

                if (nextRow < 1 || nextCol < 1 || nextRow > m || nextCol > n) {
                    continue;
                }

                if (map[row][col] > map[nextRow][nextCol]) {
                    dp[row][col] += dfs(nextRow, nextCol);
                }
            }
        }

        return dp[row][col];
    }
}
