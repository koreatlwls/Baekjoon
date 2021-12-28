package Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P21610 {

    static int n, m;
    static int[][] map;
    static ArrayList<Cloud> clouds;
    static ArrayList<Move> move;
    static int[] cloudMoveRow = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] cloudMoveCol = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] diagRow = {-1, -1, 1, 1};
    static int[] diagCol = {-1, 1, 1, -1};
    static boolean[][] cloudsVisited;

    static class Cloud {
        int row;
        int col;

        public Cloud(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static class Move {
        int dir;
        int cnt;

        public Move(int dir, int cnt) {
            this.dir = dir;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n + 1][n + 1];
        clouds = new ArrayList<>();
        move = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            move.add(new Move(a, b));
        }

        skill();
    }

    static void skill() {
        clouds.add(new Cloud(n, 1));
        clouds.add(new Cloud(n, 2));
        clouds.add(new Cloud(n - 1, 1));
        clouds.add(new Cloud(n - 1, 2));

        for (Move now : move) {
            moveClouds(now.dir, now.cnt);
            rain();
            copy();
            newClouds();
        }

        sum();
    }

    static void moveClouds(int direction, int count) {
        ArrayList<Cloud> tmp = new ArrayList<>();
        for (Cloud now : clouds) {
            int nextRow = now.row + cloudMoveRow[direction] * count;
            int nextCol = now.col + cloudMoveCol[direction] * count;

            while (!isValid(nextRow)) nextRow = change(nextRow);
            while (!isValid(nextCol)) nextCol = change(nextCol);

            tmp.add(new Cloud(nextRow, nextCol));
        }
        clouds.clear();
        clouds.addAll(tmp);
    }

    static boolean isValid(int x) {
        return x > 0 && x <= n;
    }

    static int change(int x) {
        return x < 1 ? x + n : x - n;
    }

    static void rain() {
        cloudsVisited = new boolean[n + 1][n + 1];

        for (Cloud now : clouds) {
            map[now.row][now.col] += 1;
            cloudsVisited[now.row][now.col] = true;
        }
    }

    static void copy() {
        for (Cloud now : clouds) {
            int count = 0;
            for (int i = 0; i < 4; i++) {
                int nextRow = now.row + diagRow[i];
                int nextCol = now.col + diagCol[i];

                if (nextRow > 0 && nextCol > 0 && nextRow <= n && nextCol <= n) {
                    if(map[nextRow][nextCol]>0){
                        count++;
                    }
                }
            }
            map[now.row][now.col] += count;
        }
    }

    static void newClouds() {
        ArrayList<Cloud> tmp = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] < 2) continue;
                if (cloudsVisited[i][j]) continue;

                tmp.add(new Cloud(i, j));
                map[i][j] -= 2;
            }
        }

        clouds.clear();
        clouds.addAll(tmp);
    }

    static void sum() {
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sum += map[i][j];
            }
        }

        System.out.print(sum);
    }

}
