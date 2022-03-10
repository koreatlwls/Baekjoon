package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P10711 {

    static int H, W;
    static char[][] map;
    static boolean[][] visited;

    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

    static Queue<Location> queue = new LinkedList<>();

    static class Location {
        int row;
        int col;

        public Location(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new char[H + 1][W + 1];
        visited = new boolean[H + 1][W + 1];

        for (int i = 1; i <= H; i++) {
            String input = br.readLine();
            for (int j = 1; j <= W; j++) {
                map[i][j] = input.charAt(j - 1);
            }
        }

        int num = 0;
        int cnt = 0;

        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= W; j++) {
                if (map[i][j] == '.') continue;

                num = map[i][j] - '0';

                if (num == 9) continue;

                cnt = checkCnt(i, j);

                if (cnt >= num) {
                    queue.add(new Location(i, j));
                    visited[i][j] = true;
                }
            }
        }

        System.out.print(wave());
    }

    static int checkCnt(int row, int col) {
        int cnt = 0;

        for (int i = 0; i < 8; i++) {
            int nextRow = row + dr[i];
            int nextCol = col + dc[i];

            if (map[nextRow][nextCol] == '.') {
                cnt++;
            }
        }

        return cnt;
    }

    static int wave() {
        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                Location now = queue.poll();

                int qRow = now.row;
                int qCol = now.col;

                map[qRow][qCol] = '.';

                for (int i = 0; i < 8; i++) {
                    int nextRow = qRow + dr[i];
                    int nextCol = qCol + dc[i];

                    if (nextRow < 1 || nextCol < 1 || nextRow > H || nextCol > W) continue;
                    if (map[nextRow][nextCol] == '.') continue;

                    int num = map[nextRow][nextCol] - '0';
                    if (!visited[nextRow][nextCol] && checkCnt(nextRow, nextCol) >= num) {
                        queue.add(new Location(nextRow, nextCol));
                        visited[nextRow][nextCol] = true;
                    }
                }
            }
            time++;
        }

        return time;
    }
}
