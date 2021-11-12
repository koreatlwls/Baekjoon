package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P16236 {

    public static final int maxVal = 401, maxInt = 21;
    public static int N, sharkX, sharkY, minDist, minX, minY, result, eatCnt = 0, sharkSize = 2;
    public static int[][] a, check;
    public static int[] dx = {0, 0, 1, -1}, dy = {-1, 1, 0, 0};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        a = new int[N + 1][N + 1];
        check = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());

                if (a[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                    a[i][j] = 0;
                }
            }
        }

        while (true) {
            init_check();

            bfs(sharkX, sharkY);

            if (minX != maxInt && minY != maxInt) {
                result += check[minX][minY];

                eatCnt++;

                if (eatCnt == sharkSize) {
                    sharkSize++;
                    eatCnt = 0;
                }

                a[minX][minY] = 0;

                sharkX = minX;
                sharkY = minY;
            } else {
                break;
            }
        }

        System.out.println(result);
    }

    public static void init_check() {
        minDist = maxVal;
        minX = maxInt;
        minY = maxInt;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                check[i][j] = -1;
            }
        }
    }

    public static void bfs(int x, int y) {
        Queue<Shark> queue = new LinkedList<Shark>();
        check[x][y] = 0;
        queue.add(new Shark(x, y));

        while (!queue.isEmpty()) {
            Shark cur = queue.poll();
            x = cur.x;
            y = cur.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 1 || nx > N || ny < 1 || ny > N)
                    continue;
                if (check[nx][ny] != -1 || a[nx][ny] > sharkSize)
                    continue;

                check[nx][ny] = check[x][y] + 1;

                if (a[nx][ny] != 0 && a[nx][ny] < sharkSize) {

                    if (minDist > check[nx][ny]) {
                        minX = nx;
                        minY = ny;
                        minDist = check[nx][ny];
                    } else if (minDist == check[nx][ny]) {
                        if (minX == nx) {
                            if (minY > ny) {
                                minX = nx;
                                minY = ny;
                            }
                        } else if (minX > nx) {
                            minX = nx;
                            minY = ny;
                        }
                    }
                }

                queue.add(new Shark(nx, ny));
            }
        }

    }

    static class Shark {
        int x;
        int y;

        Shark(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
}
