package Algorithm.BFS;

import java.awt.*;
import java.io.*;
import java.util.*;

public class P03184 {

    static int R, C;
    static char[][] board;
    static boolean[][] visited;
    static int sheep = 0, wolf = 0;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = input.charAt(j);
                if (board[i][j] == 'o') sheep++;
                else if (board[i][j] == 'v') wolf++;
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] != '#' && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.print(sheep + " " + wolf);
    }

    static void bfs(int row, int col) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(row, col));
        visited[row][col] = true;

        int sheepCnt = 0;
        int wolfCnt = 0;

        if (board[row][col] == 'o') sheepCnt++;
        else if (board[row][col] == 'v') wolfCnt++;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = now.x + dr[i];
                int nextCol = now.y + dc[i];

                if (nextRow < 0 || nextCol < 0 || nextRow >= R || nextCol >= C) continue;
                if (visited[nextRow][nextCol] || board[nextRow][nextCol] == '#') continue;

                if (board[nextRow][nextCol] == 'o') sheepCnt++;
                else if (board[nextRow][nextCol] == 'v') wolfCnt++;

                queue.add(new Point(nextRow, nextCol));
                visited[nextRow][nextCol] = true;
            }
        }

        if (sheepCnt > wolfCnt) {
            wolf -= wolfCnt;
        } else {
            sheep -= sheepCnt;
        }
    }
}
