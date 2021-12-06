package Algorithm.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P02468 {

    static int n;
    static int[][] map;
    static int[][] check;
    static int maxResult = Integer.MIN_VALUE;
    static int maxValue = Integer.MIN_VALUE;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxValue = Math.max(maxValue, map[i][j]);
            }
        }

        for(int k=0;k<=maxValue;k++){
            int count = 0;
            check = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] > k && check[i][j] == 0) {
                        dfs(i, j, ++count, k);
                    }
                }
            }
            maxResult = Math.max(count, maxResult);
        }

        System.out.print(maxResult);
    }

    static void dfs(int row, int col, int count, int height) {
        check[row][col] = count;

        for (int i = 0; i < 4; i++) {
            int nextRow = row + dr[i];
            int nextCol = col + dc[i];

            if (nextRow < 0 || nextCol < 0 || nextRow >= n || nextCol >= n) {
                continue;
            }

            if (check[nextRow][nextCol] > 0 || map[nextRow][nextCol] <= height) {
                continue;
            }

            dfs(nextRow, nextCol, count, height);
        }
    }
}
