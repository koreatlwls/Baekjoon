package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P02638 {

    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Point> cheeselist;
    static int cheesecnt;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        cheeselist = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    cheeselist.add(new Point(i, j));
                    cheesecnt++;
                }
            }
        }

        int time = 0;
        while (cheesecnt != 0) {
            time++;
            visited = new boolean[n][m];
            bfs();
            melting();
        }

        System.out.print(time);
    }

    static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        visited[0][0] = true;
        map[0][0] = 2;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = now.row + dr[i];
                int nextCol = now.col + dc[i];

                if (nextRow < 0 || nextCol < 0 || nextRow >= n || nextCol >= m) continue;
                if (visited[nextRow][nextCol] || map[nextRow][nextCol] == 1) continue;

                map[nextRow][nextCol] = 2;
                queue.offer(new Point(nextRow, nextCol));
                visited[nextRow][nextCol] = true;
            }
        }
    }

    static void melting() {
        for (int i = 0; i < cheeselist.size(); i++) {
            int row = cheeselist.get(i).row;
            int col = cheeselist.get(i).col;
            int cnt = 0;

            for (int j = 0; j < 4; j++) {
                int nr = row + dr[j];
                int nc = col + dc[j];

                if (map[nr][nc] == 2) {
                    cnt++;
                }
            }

            if (cnt >= 2) {
                map[row][col] = 0;
                cheesecnt--;
                cheeselist.remove(i);
                i--;
            }
        }
    }
}
