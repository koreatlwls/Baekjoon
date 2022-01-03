package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P17836 {

    static int n, m, t;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Knight {
        int row;
        int col;
        int cnt;
        boolean isSword;

        public Knight(int row, int col, int cnt, boolean isSword) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
            this.isSword = isSword;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1][2];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = bfs();
        if (result > t || result == -1) {
            System.out.print("Fail");
        } else {
            System.out.print(result);
        }
    }

    static int bfs() {
        Queue<Knight> queue = new LinkedList<>();
        queue.add(new Knight(1, 1, 0, false));
        visited[1][1][0] = true;

        while (!queue.isEmpty()) {
            Knight now = queue.poll();

            if (now.row == n && now.col == m) {
                return now.cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = now.row + dr[i];
                int nextCol = now.col + dc[i];

                if (nextRow > 0 && nextCol > 0 && nextRow <= n && nextCol <= m) {
                    if (!now.isSword) {
                        if (!visited[nextRow][nextCol][0] && map[nextRow][nextCol] == 0) {
                            queue.add(new Knight(nextRow, nextCol, now.cnt + 1, now.isSword));
                            visited[nextRow][nextCol][0] = true;
                        } else if (!visited[nextRow][nextCol][0] && map[nextRow][nextCol] == 2) {
                            queue.add(new Knight(nextRow, nextCol, now.cnt + 1, true));
                            visited[nextRow][nextCol][0] = true;
                        }
                    } else {
                        if (!visited[nextRow][nextCol][1]) {
                            queue.add(new Knight(nextRow, nextCol, now.cnt + 1, now.isSword));
                            visited[nextRow][nextCol][1] = true;
                        }

                    }
                }
            }
        }

        return -1;
    }
}
