package Algorithm.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P01261 {

    static int n, m;
    static int[][] map;
    static int[][] dist;
    static final int INF = (int) 1e9;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int result = 0;

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

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = Character.getNumericValue(input.charAt(j));
                dist[i][j] = INF;
            }
        }

        dijkstra();
        System.out.print(result);
    }

    static void dijkstra() {
        PriorityQueue<Spot> pq = new PriorityQueue<>();
        pq.offer(new Spot(0, 0, 0));
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            Spot now = pq.poll();

            if (now.row == n - 1 && now.col == m - 1) {
                result = now.cost;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = now.row + dr[i];
                int nextCol = now.col + dc[i];

                if (nextRow < 0 || nextCol < 0 || nextRow >= n || nextCol >= m) continue;

                if (dist[nextRow][nextCol] > dist[now.row][now.col] + map[nextRow][nextCol]) {
                    dist[nextRow][nextCol] = dist[now.row][now.col] + map[nextRow][nextCol];
                    pq.offer(new Spot(nextRow, nextCol, dist[nextRow][nextCol]));
                }
            }
        }
    }
}
