package Algorithm.BFS;

import java.awt.*;
import java.io.*;
import java.util.*;

public class P11123 {

    static int H, W;
    static char[][] board;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            board = new char[H][W];
            visited = new boolean[H][W];

            for (int i = 0; i < H; i++) {
                String input = br.readLine();
                for (int j = 0; j < W; j++) {
                    board[i][j] = input.charAt(j);
                }
            }

            int cnt = 0;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (!visited[i][j] && board[i][j] != '.') {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
    }

    static void bfs(int row, int col) {
        visited[row][col] = true;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(row, col));

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = now.x + dr[i];
                int nextCol = now.y + dc[i];

                if (nextRow < 0 || nextCol < 0 || nextRow >= H || nextCol >= W) continue;
                if (visited[nextRow][nextCol] || board[nextRow][nextCol] == '.') continue;

                visited[nextRow][nextCol] = true;
                queue.offer(new Point(nextRow, nextCol));
            }
        }
    }
}
