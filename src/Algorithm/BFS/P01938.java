package Algorithm.BFS;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P01938 {

    static int N;
    static char[][] map;
    static Point[] BP, EP;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Tree {
        int x;
        int y;
        int dir;
        int cnt;

        public Tree(int x, int y, int dir, int cnt) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        BP = new Point[3];
        EP = new Point[3];

        int bi = 0;
        int ei = 0;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j);

                if (map[i][j] == 'B') {
                    BP[bi++] = new Point(i, j);
                }
                if (map[i][j] == 'E') {
                    EP[ei++] = new Point(i, j);
                }
            }
        }

        System.out.print(bfs());
    }

    static int bfs() {
        boolean[][][] visited = new boolean[2][N][N];
        Queue<Tree> queue = new LinkedList<>();
        int dir = 0;
        if (BP[0].y + 1 == BP[1].y) dir = 0;
        else dir = 1;

        queue.add(new Tree(BP[1].x, BP[1].y, dir, 0));
        visited[dir][BP[1].x][BP[1].y] = true;

        while (!queue.isEmpty()) {
            Tree now = queue.poll();
            if (now.x == EP[1].x && now.y == EP[1].y) {
                if (now.dir == 0 && map[now.x][now.y - 1] == 'E' && map[now.x][now.y + 1] == 'E') {
                    return now.cnt;
                } else if (now.dir == 1 && map[now.x - 1][now.y] == 'E' && map[now.x + 1][now.y] == 'E') {
                    return now.cnt;
                }
            }

            for (int i = 0; i < 4; i++) {
                int xx = now.x + dx[i];
                int yy = now.y + dy[i];

                if (now.dir == 0) {
                    if (!checkHoriz(xx, yy, i)) continue;
                } else {
                    if (!checkVerti(xx, yy, i)) continue;
                }

                if (visited[now.dir][xx][yy]) continue;

                visited[now.dir][xx][yy] = true;
                queue.add(new Tree(xx, yy, now.dir, now.cnt + 1));
            }

            if (canRotation(now.x, now.y)) {
                if (now.dir == 0 && !visited[1][now.x][now.y]) {
                    visited[1][now.x][now.y] = true;
                    queue.add(new Tree(now.x, now.y, 1, now.cnt + 1));
                } else if (now.dir == 1 && !visited[0][now.x][now.y]) {
                    visited[0][now.x][now.y] = true;
                    queue.add(new Tree(now.x, now.y, 0, now.cnt + 1));
                }
            }
        }

        return 0;
    }

    static boolean checkVerti(int xx, int yy, int d) {
        if (d < 2) {
            if (xx - 1 < 0 || xx + 1 >= N) return false;
            if (map[xx][yy] == '1' || map[xx - 1][yy] == '1' || map[xx + 1][yy] == '1') return false;
        }
        else {
            if (yy < 0 || yy >= N) return false;
            if (map[xx][yy] == '1' || map[xx - 1][yy] == '1' || map[xx + 1][yy] == '1') return false;
        }

        return true;
    }

    static boolean checkHoriz(int xx, int yy, int d) {
        if (d < 2) {
            if (xx < 0 || xx >= N) return false;
            if (map[xx][yy] == '1' || map[xx][yy-1] == '1' || map[xx][yy+1] == '1') return false;
        }
        else {
            if (yy - 1 < 0 || yy + 1 >= N) return false;
            if (map[xx][yy] == '1' || map[xx][yy - 1] == '1' || map[xx][yy + 1] == '1') return false;
        }

        return true;
    }

    static boolean canRotation(int x, int y) {
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i < 0 || j < 0 || i >= N || j >= N) return false;
                if (map[i][j] == '1') return false;
            }
        }

        return true;
    }
}
