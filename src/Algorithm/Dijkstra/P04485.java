package Algorithm.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P04485 {

    static int n;
    static int[][] map;
    static int[][] dist;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static final int INF = (int) 1e9;
    static int result;

    static class Spot implements Comparable<Spot> {
        int row;
        int col;
        int cost;

        public Spot(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }

        @Override
        public int compareTo(Spot o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int cnt = 1;
        while (true) {
            n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }

            map = new int[n][n];
            dist = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = INF;
                }
            }

            result = 0;
            dijkstra();
            sb.append("Problem " + cnt + ": " + result).append("\n");
            cnt++;
        }

        System.out.print(sb);
    }

    static void dijkstra() {
        PriorityQueue<Spot> pq = new PriorityQueue<>();
        pq.offer(new Spot(0, 0, map[0][0]));
        dist[0][0] = map[0][0];

        while (!pq.isEmpty()) {
            Spot now = pq.poll();

            if (now.row == n - 1 && now.col == n - 1) {
                result = now.cost;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = now.row + dr[i];
                int nextCol = now.col + dc[i];

                if (nextRow < 0 || nextCol < 0 || nextRow >= n || nextCol >= n) continue;

                if (dist[nextRow][nextCol] > dist[now.row][now.col] + map[nextRow][nextCol]) {
                    dist[nextRow][nextCol] = dist[now.row][now.col] + map[nextRow][nextCol];
                    pq.offer(new Spot(nextRow, nextCol, dist[nextRow][nextCol]));
                }
            }
        }
    }
}
