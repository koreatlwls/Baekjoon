package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P17070 {

    static int n;
    static int count = 0;
    static int[][] map;

    static class Pipe {
        int row;
        int col;
        int direction; // 가로0 세로1 대각선2

        public Pipe(int row, int col, int direction) {
            this.row = row;
            this.col = col;
            this.direction = direction;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (map[n][n] == 1) {
            System.out.println(0);
            return;
        }

        bfs();
        System.out.print(count);
    }

    static void bfs() {
        Queue<Pipe> queue = new LinkedList<>();
        queue.offer(new Pipe(1, 2, 0));

        while (!queue.isEmpty()) {
            Pipe now = queue.poll();

            if (now.row == n && now.col == n) {
                count++;
                continue;
            }

            if (now.direction == 0) {
                if (isPossible(now, 0)) {
                    queue.offer(new Pipe(now.row, now.col + 1, 0));
                }
                if (isPossible(now, 2)) {
                    queue.offer(new Pipe(now.row + 1, now.col + 1, 2));
                }
            } else if (now.direction == 1) {
                if (isPossible(now, 1)) {
                    queue.offer(new Pipe(now.row + 1, now.col, 1));
                }
                if (isPossible(now, 2)) {
                    queue.offer(new Pipe(now.row + 1, now.col + 1, 2));
                }
            } else {
                if (isPossible(now, 0)) {
                    queue.offer(new Pipe(now.row, now.col + 1, 0));
                }
                if (isPossible(now, 1)) {
                    queue.offer(new Pipe(now.row + 1, now.col, 1));
                }
                if (isPossible(now, 2)) {
                    queue.offer(new Pipe(now.row + 1, now.col + 1, 2));
                }
            }
        }
    }

    static boolean isPossible(Pipe pipe, int dir) {
        switch (dir) {
            case 0:
                return pipe.col + 1 <= n && map[pipe.row][pipe.col + 1] != 1;
            case 1:
                return pipe.row + 1 <= n && map[pipe.row + 1][pipe.col] != 1;
            case 2:
                return pipe.row + 1 <= n && pipe.col + 1 <= n && map[pipe.row][pipe.col + 1] != 1 && map[pipe.row + 1][pipe.col + 1] != 1 && map[pipe.row + 1][pipe.col] != 1;
        }

        return false;
    }
}
