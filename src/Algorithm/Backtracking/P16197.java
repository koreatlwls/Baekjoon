package Algorithm.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P16197 {

    static int n, m;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static char[][] board;
    static Coin[] coin;
    static boolean[][][][] visited;

    static class Coin {
        int row;
        int col;

        public Coin(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static class towCoins {
        int rowA;
        int colA;
        int rowB;
        int colB;
        int count;

        public towCoins(int rowA, int colA, int rowB, int colB, int count) {
            this.rowA = rowA;
            this.colA = colA;
            this.rowB = rowB;
            this.colB = colB;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        coin = new Coin[2];

        int coinIdx = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = str.charAt(j);
                if (board[i][j] == 'o') {
                    coin[coinIdx++] = new Coin(i, j);
                }
            }
        }

        visited = new boolean[n][m][n][m];
        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<towCoins> queue = new LinkedList<>();
        queue.offer(new towCoins(coin[0].row, coin[0].col, coin[1].row, coin[1].col, 0));
        visited[coin[0].row][coin[0].col][coin[1].row][coin[1].col] = true;

        while (!queue.isEmpty()) {
            towCoins current = queue.poll();

            if (current.count >= 10) break;

            for (int i = 0; i < 4; i++) {
                int nextRowA = current.rowA + dr[i];
                int nextColA = current.colA + dc[i];
                int nextRowB = current.rowB + dr[i];
                int nextColB = current.colB + dc[i];

                if (!canMoveCoin(nextRowA, nextColA)) {
                    nextRowA = current.rowA;
                    nextColA = current.colA;
                }
                if (!canMoveCoin(nextRowB, nextColB)) {
                    nextRowB = current.rowB;
                    nextColB = current.colB;
                }

                int flag = 0;
                if (nextRowA >= 0 && nextColA >= 0 && nextRowA < n && nextColA < m) flag++;
                if (nextRowB >= 0 && nextColB >= 0 && nextRowB < n && nextColB < m) flag++;

                if (flag == 1) return current.count + 1;
                else if (flag == 2 && !visited[nextRowA][nextColA][nextRowB][nextColB]) {
                    visited[nextRowA][nextColA][nextRowB][nextColB] = true;
                    queue.offer(new towCoins(nextRowA, nextColA, nextRowB, nextColB, current.count + 1));
                }
            }
        }
        return -1;
    }

    static boolean canMoveCoin(int row, int col) {
        if (row >= 0 && col >= 0 && row < n && col < m && board[row][col] == '#') {
            return false;
        }
        return true;
    }
}
