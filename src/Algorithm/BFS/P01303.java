package Algorithm.BFS;

import java.awt.*;
import java.io.*;
import java.util.*;

public class P01303 {

    static int N, M;
    static int whiteScore = 0, blueScore = 0;
    static char[][] board;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    if (board[i][j] == 'W') {
                        whiteScore += bfs(i, j, 'W');
                    } else {
                        blueScore += bfs(i, j, 'B');
                    }
                }
            }
        }

        System.out.print(whiteScore + " " + blueScore);
    }

    static int bfs(int row, int col, char team) {
        int cnt = 1;
        visited[row][col] = true;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(row, col));

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for(int i=0;i<4;i++){
                int nextRow = now.x + dr[i];
                int nextCol = now.y + dc[i];

                if(nextRow <0 || nextRow >=M || nextCol <0 || nextCol >=N)continue;
                if(visited[nextRow][nextCol] || board[nextRow][nextCol] != team) continue;

                queue.add(new Point(nextRow, nextCol));
                visited[nextRow][nextCol] = true;
                cnt++;
            }
        }

        return cnt * cnt;
    }
}
