package Algorithm.BFS;

import java.awt.*;
import java.io.*;
import java.util.*;

public class P16174 {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {0, 1};
    static int[] dc = {1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (bfs()) {
            System.out.print("HaruHaru");
        } else {
            System.out.print("Hing");
        }
    }

    static boolean bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            if (map[now.x][now.y] == -1) {
                return true;
            }

            for (int i = 0; i < 2; i++) {
                int nextRow = now.x + dr[i] * map[now.x][now.y];
                int nextCol = now.y + dc[i] * map[now.x][now.y];

                if (nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= N) continue;
                if (visited[nextRow][nextCol]) continue;

                visited[nextRow][nextCol] = true;
                queue.add(new Point(nextRow, nextCol));
            }
        }

        return false;
    }
}
