package Algorithm.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P01987 {

    static int r, c;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static char[][] inputArr;
    static boolean[] visited = new boolean[26];
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        inputArr = new char[r][c];
        for (int i = 0; i < r; i++) {
            String input = br.readLine();
            for (int j = 0; j < c; j++) {
                inputArr[i][j] = input.charAt(j);
            }
        }

        dfs(0, 0, 0);

        System.out.print(max);
    }

    static void dfs(int row, int col, int count) {
        if (visited[inputArr[row][col] - 'A']) {
            max = Math.max(max, count);
            return;
        } else {
            visited[inputArr[row][col] - 'A'] = true;
            for (int i = 0; i < 4; i++) {
                int nextRow = row + dr[i];
                int nextCol = col + dc[i];

                if (nextRow < 0 || nextCol < 0 || nextRow >= r || nextCol >= c) continue;

                dfs(nextRow, nextCol, count + 1);
            }
        }

        visited[inputArr[row][col] - 'A'] = false;
    }
}
