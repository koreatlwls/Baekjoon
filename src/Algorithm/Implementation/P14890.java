package Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14890 {

    static int n, l;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (calRow(i)) count++;
            if (calCol(i)) count++;
        }
        System.out.print(count);
    }

    static boolean calRow(int row) {
        boolean[] isIncline = new boolean[n];

        for (int i = 0; i < n - 1; i++) {
            int diff = board[row][i] - board[row][i + 1];

            if (diff > 1 || diff < -1) return false;
            else if (diff == -1) {
                for (int j = 0; j < l; j++) {
                    if (i - j < 0 || isIncline[i - j]) return false;
                    if (board[row][i] != board[row][i - j]) return false;
                    isIncline[i - j] = true;
                }
            } else if (diff == 1) {
                for (int j = 1; j <= l; j++) {
                    if (i + j >= n || isIncline[i + j]) return false;
                    if (board[row][i] - 1 != board[row][i + j]) return false;
                    isIncline[i + j] = true;
                }
            }
        }
        return true;
    }

    static boolean calCol(int col) {
        boolean[] isIncline = new boolean[n];

        for (int i = 0; i < n - 1; i++) {
            int diff = board[i][col] - board[i + 1][col];

            if (diff > 1 || diff < -1) return false;
            else if (diff == -1) {
                for (int j = 0; j < l; j++) {
                    if (i - j < 0 || isIncline[i - j]) return false;
                    if (board[i][col] != board[i - j][col]) return false;
                    isIncline[i - j] = true;
                }
            } else if (diff == 1) {
                for (int j = 1; j <= l; j++) {
                    if (i + j >= n || isIncline[i + j]) return false;
                    if (board[i][col] - 1 != board[i + j][col]) return false;
                    isIncline[i + j] = true;
                }
            }
        }
        return true;
    }
}
