package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P16973 {

    static class Rect {
        int row;
        int col;
        int cnt;

        public Rect(int row, int col, int cnt) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
        }
    }

    static int N, M, answer;
    static int H, W, Sr, Sc, Fr, Fc;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visited;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        board = new int[N][M];

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; ++j) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        Sr = Integer.parseInt(st.nextToken()) - 1;
        Sc = Integer.parseInt(st.nextToken()) - 1;
        Fr = Integer.parseInt(st.nextToken()) - 1;
        Fc = Integer.parseInt(st.nextToken()) - 1;

        answer = -1;
        bfs();

        System.out.println(answer);
    }

    public static void bfs() {
        Queue<Rect> queue = new LinkedList<>();
        queue.offer(new Rect(Sr, Sc, 0));
        visited[Sr][Sc] = true;

        while (!queue.isEmpty()) {
            Rect now = queue.poll();

            for (int i = 0; i < 4; ++i) {
                int nextRow = now.row + dr[i];
                int nextCol = now.col + dc[i];

                if (nextRow == Fr && nextCol == Fc) {
                    answer = now.cnt + 1;
                    return;
                }

                if (nextCol < 0 || nextRow < 0 || nextCol >= M || nextRow >= N) {
                    continue;
                }

                if (!visited[nextRow][nextCol] && board[nextRow][nextCol] == 0) {
                    if (!check(nextRow, nextCol)) {
                        continue;
                    }

                    queue.offer(new Rect(nextRow, nextCol, now.cnt + 1));
                    visited[nextRow][nextCol] = true;
                }
            }
        }
    }

    public static boolean check(int row, int col) {
        int nextRow = row + H;
        int nextCol = col + W;

        if (nextRow - 1 >= N || nextCol - 1 >= M) {
            return false;
        }

        for (int i = row; i < nextRow; ++i) {
            for (int j = col; j < nextCol; ++j) {
                if (board[i][j] == 1) {
                    return false;
                }
            }
        }

        return true;
    }
}