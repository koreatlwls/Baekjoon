package Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P16918 {

    static int R, C, N;
    static char[][] board;
    static int[][] bomb;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        bomb = new int[R][C];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = input.charAt(j);
                if (board[i][j] == 'O') {
                    bomb[i][j] = 3;
                }
            }
        }

        solve();

        for (int i = 0; i < R; i++) {
            System.out.println(board[i]);
        }
    }

    static void solve() {
        int time = 0;

        while (time++ < N) {
            if (time % 2 == 0) {
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (board[i][j] == '.') {
                            board[i][j] = 'O';
                            bomb[i][j] = time + 3;
                        }
                    }
                }
            } else if (time % 2 == 1) {
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (bomb[i][j] == time) {
                            board[i][j] = '.';
                            for (int d = 0; d < 4; d++) {
                                int nextRow = i + dr[d];
                                int nextCol = j + dc[d];

                                if (nextRow < 0 || nextCol < 0 || nextRow >= R || nextCol >= C) continue;

                                if (board[nextRow][nextCol] == 'O' && bomb[nextRow][nextCol] != time) {
                                    board[nextRow][nextCol] = '.';
                                    bomb[nextRow][nextCol] = 0;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
