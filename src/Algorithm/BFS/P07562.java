package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P07562 {

    static int[] dc = {2, 1, -1, -2, -1, -2, 2, 1};
    static int[] dr = {1, 2, 2, 1, -2, -1, -1, -2};
    static boolean[][] map;
    static int width;
    static int startRow, startCol;
    static int endRow, endCol;
    static int count;

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

        int testcase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testcase; i++) {
            width = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            startRow = Integer.parseInt(st.nextToken());
            startCol = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            endRow = Integer.parseInt(st.nextToken());
            endCol = Integer.parseInt(st.nextToken());

            count = 0;
            map = new boolean[width][width];
            bfs();
            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }

    static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(startRow, startCol));
        map[startRow][startCol] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point now = queue.poll();

                if(now.row == endRow && now.col == endCol)return;

                for (int j = 0; j < 8; j++) {
                    int nextRow = now.row + dr[j];
                    int nextCol = now.col + dc[j];

                    if (nextRow < 0 || nextCol < 0 || nextRow >= width || nextCol >= width) continue;
                    if (map[nextRow][nextCol]) continue;

                    map[nextRow][nextCol] = true;
                    queue.offer(new Point(nextRow, nextCol));
                }
            }
            count++;
        }
    }
}
