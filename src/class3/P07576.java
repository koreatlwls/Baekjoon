package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P07576 {

    static int[][] map;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int M, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        M = Integer.parseInt(stringTokenizer.nextToken());
        N = Integer.parseInt(stringTokenizer.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if (map[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        System.out.print(bfs());
    }

    static int bfs() {
        while (!queue.isEmpty()) {
            int[] newArr = queue.poll();

            int row = newArr[0];
            int col = newArr[1];

            for (int i = 0; i < 4; i++) {
                int moveRow = row + dy[i];
                int moveCol = col + dx[i];
                if (checkPoint(moveRow, moveCol)) {
                    queue.add(new int[]{moveRow, moveCol});
                    map[moveRow][moveCol] = map[row][col] + 1;
                }
            }
        }

        int result = Integer.MIN_VALUE;

        for (int j = 0; j < N; j++) {
            for (int k = 0; k < M; k++) {
                if (map[j][k] == 0) return -1;
                result = Math.max(result, map[j][k]);
            }
        }

        if (result == 1) return 0;
        else return (result - 1);
    }

    static boolean checkPoint(int row, int col) {
        if (row < 0 || row >= N || col < 0 || col >= M)
            return false;
        if (map[row][col] == 0)
            return true;
        else
            return false;
    }
}
