package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P01600 {

    static int k, r, c;
    static int[][] map;
    static boolean[][][] visited;

    static int[] newDr = {2, 1, -1, -2, 2, 1, -2, -1};
    static int[] newDc = {-1, -2, -2, -1, 1, 2, 1, 2};
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Node {
        int row;
        int col;
        int kCnt;
        int cnt;

        public Node(int row, int col, int kCnt, int cnt) {
            this.row = row;
            this.col = col;
            this.kCnt = kCnt;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        visited = new boolean[r][c][k + 1];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int min = bfs();
        System.out.print(min == Integer.MAX_VALUE ? -1 : min);
    }

    static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, k, 0));
        visited[0][0][k] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (now.row == r - 1 && now.col == c - 1) {
                return now.cnt;
            }

            if (now.kCnt > 0) {
                for (int i = 0; i < 8; i++) {
                    int nextRow = now.row + newDr[i];
                    int nextCol = now.col + newDc[i];

                    if (nextRow < 0 || nextCol < 0 || nextRow >= r || nextCol >= c) continue;
                    if (visited[nextRow][nextCol][now.kCnt - 1] || map[nextRow][nextCol] == 1) continue;

                    visited[nextRow][nextCol][now.kCnt - 1] = true;
                    queue.offer(new Node(nextRow, nextCol, now.kCnt - 1, now.cnt + 1));
                }
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = now.row + dr[i];
                int nextCol = now.col + dc[i];

                if (nextRow < 0 || nextCol < 0 || nextRow >= r || nextCol >= c) continue;
                if (visited[nextRow][nextCol][now.kCnt] || map[nextRow][nextCol] == 1) continue;

                visited[nextRow][nextCol][now.kCnt] = true;
                queue.offer(new Node(nextRow, nextCol, now.kCnt, now.cnt + 1));
            }
        }

        return Integer.MAX_VALUE;
    }
}
