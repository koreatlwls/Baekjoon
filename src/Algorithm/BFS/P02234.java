package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P02234 {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};

    static class Room {
        int row;
        int col;

        public Room(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // col
        M = Integer.parseInt(st.nextToken()); // row

        map = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int room = 0;
        int max = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    max = Math.max(max, bfs(i, j));
                    room++;
                }
            }
        }

        System.out.println(room);
        System.out.println(max);

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                for (int bit = 1; bit <= 8; bit <<= 1) {
                    visited = new boolean[M][N];
                    map[i][j] -= bit;
                    max = Math.max(max, bfs(i, j));
                    map[i][j] += bit;
                }
            }
        }

        System.out.println(max);
    }

    static int bfs(int row, int col) {
        Queue<Room> queue = new LinkedList<>();
        queue.offer(new Room(row, col));
        visited[row][col] = true;

        int cnt = 1;

        while (!queue.isEmpty()) {
            Room now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = now.row + dr[i];
                int nextCol = now.col + dc[i];

                if (nextRow < 0 || nextCol < 0 || nextRow >= M || nextCol >= N || visited[nextRow][nextCol] || (map[now.row][now.col] & (1 << i)) > 0) {
                    continue;
                }

                queue.offer(new Room(nextRow, nextCol));
                visited[nextRow][nextCol] = true;
                cnt++;
            }
        }

        return cnt;
    }
}
