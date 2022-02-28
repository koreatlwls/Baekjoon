package Algorithm.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P17136 {

    static int[][] board;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        board = new int[10][10];
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] remain = {0, 5, 5, 5, 5, 5};
        bp(0, 0, remain, 0);

        if (min == Integer.MAX_VALUE) System.out.print(-1);
        else System.out.print(min);
    }

    static void bp(int x, int y, int[] remain, int count) {
        if (x == 9 && y == 10) {
            min = Math.min(min, count);
            return;
        }

        if (y == 10) {
            bp(x + 1, 0, remain, count);
            return;
        }

        if (count >= min) return;

        if (board[x][y] == 1) {
            for (int j = 5; j >= 1; j--) {
                if (isAttach(x, y, j) && remain[j] > 0) {
                    attach(x, y, j);
                    remain[j]--;
                    bp(x, y + 1, remain, count + 1);
                    detach(x, y, j);
                    remain[j]++;
                }
            }
        } else {
            bp(x, y + 1, remain, count);
        }
    }

    static void attach(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                board[i][j] = 2;
            }
        }
    }

    static void detach(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                board[i][j] = 1;
            }
        }
    }

    static boolean isAttach(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (i >= 10 || j >= 10) return false;
                if (board[i][j] != 1) return false;
            }
        }
        return true;
    }
}
