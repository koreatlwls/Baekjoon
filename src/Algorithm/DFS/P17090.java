package Algorithm.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P17090 {

    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dfs(i, j)) {
                    ans++;
                }
            }
        }

        System.out.print(ans);
    }

    static boolean dfs(int row, int col) {
        boolean result = false;
        if (row < 0 || col < 0 || row >= N || col >= M)
            return true;

        if (map[row][col] == 'T') return true;
        else if (map[row][col] == 'F') return false;

        if (visited[row][col]) return false;

        visited[row][col] = true;
        if (map[row][col] == 'D') {
            result = dfs(row + 1, col);
        } else if (map[row][col] == 'U') {
            result = dfs(row - 1, col);
        } else if (map[row][col] == 'R') {
            result = dfs(row, col + 1);
        } else if (map[row][col] == 'L') {
            result = dfs(row, col - 1);
        }

        map[row][col] = result ? 'T' : 'F';

        return result;
    }
}
