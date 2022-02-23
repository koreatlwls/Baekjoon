package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P14940 {

    static int N, M;
    static int[][] map;
    static int[][] dist;
    static boolean[][] visited;
    static Road start;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Road {
        int row;
        int col;
        int cnt;

        public Road(int row, int col, int cnt) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dist = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    start = new Road(i, j, 0);
                    dist[i][j] = 0;
                }
            }
        }

        bfs();
        print();
    }

    static void bfs() {
        Queue<Road> queue = new LinkedList<>();
        queue.add(start);
        visited[start.row][start.col] = true;

        while (!queue.isEmpty()) {
            Road now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = now.row + dr[i];
                int nextCol = now.col + dc[i];

                if (nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= M || visited[nextRow][nextCol] || map[nextRow][nextCol] == 0) continue;

                visited[nextRow][nextCol] = true;
                dist[nextRow][nextCol] = now.cnt + 1;
                queue.add(new Road(nextRow, nextCol, now.cnt + 1));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if (map[i][j] != 0 && !visited[i][j]) {
                    dist[i][j] = -1;
                }
            }
        }
    }

    static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}
