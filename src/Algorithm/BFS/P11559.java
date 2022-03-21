package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class P11559 {

    static char[][] board;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visited;
    static ArrayList<Node> list;
    static int N = 12, M = 6;

    static class Node {
        int row;
        int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        int count = 0;
        while (true) {
            boolean isFinished = true;
            visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j] != '.') {
                        list = new ArrayList<>();
                        bfs(board[i][j], i, j);

                        if (list.size() >= 4) {
                            isFinished = false;
                            for (int k = 0; k < list.size(); k++) {
                                board[list.get(k).row][list.get(k).col] = '.';
                            }
                        }
                    }
                }
            }
            if (isFinished) break;
            fallPuyos();
            count++;
        }

        System.out.print(count);
    }

    static void fallPuyos() {
        for (int i = 0; i < M; i++) {
            for (int j = N - 1; j > 0; j--) {
                if (board[j][i] == '.') {
                    for (int k = j - 1; k >= 0; k--) {
                        if (board[k][i] != '.') {
                            board[j][i] = board[k][i];
                            board[k][i] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }

    static void bfs(char c, int row, int col) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(row, col));
        list.add(new Node(row, col));
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = now.row + dr[i];
                int nextCol = now.col + dc[i];

                if (nextRow >= 0 && nextCol >= 0 && nextRow < N && nextCol < M && !visited[nextRow][nextCol] && board[nextRow][nextCol] == c) {
                    visited[nextRow][nextCol] = true;
                    list.add(new Node(nextRow, nextCol));
                    queue.add(new Node(nextRow, nextCol));
                }
            }
        }
    }
}
