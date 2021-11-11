package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14500 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(stringTokenizer.nextToken());
        int x = Integer.parseInt(stringTokenizer.nextToken());
        int[][] map = new int[y][x];
        int[][] moveX = {{0, 1, 2, 3}, {0, 1, 0, 1}, {0, 0, 0, 1}, {0, 1, 2, 1}, {0, 0, 0, 0}, {0, 1, 2, 2}, {0, 0, 1, 2}, {0, 0, 1, 2}, {0, 1, 2, 2}, {0, 1, 1, 1}, {0, 0, 0, 1}, {0, 1, 1, 1}, {0, 0, 1, 1}, {0, 1, 1, 2}, {0, 1, 1, 2}, {0, 1, 1, 2}, {0, 1, 1, 1}, {0, 0, 0, 1}, {0, 0, 1, 1}};
        int[][] moveY = {{0, 0, 0, 0}, {1, 0, 0, 1}, {0, 1, 2, 2}, {0, 0, 0, 1}, {0, 1, 2, 3}, {0, 0, 0, 1}, {0, 1, 0, 0}, {0, 1, 1, 1}, {1, 1, 1, 0}, {0, 0, 1, 2}, {0, 1, 2, 0}, {2, 2, 1, 0}, {1, 2, 0, 1}, {1, 1, 0, 0}, {0, 0, 1, 1}, {1, 1, 0, 1}, {1, 0, 1, 2}, {0, 1, 2, 1}, {0, 1, 1, 2}};

        for (int i = 0; i < y; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                for (int a = 0; a < 19; a++) {
                    int value = 0;
                    for (int b = 0; b < 4; b++) {
                        int nextX = j + moveX[a][b];
                        int nextY = i + moveY[a][b];
                        if (nextX >= x || nextY >= y)
                            continue;
                        value += map[nextY][nextX];
                    }
                    max = Math.max(max, value);
                }
            }
        }
        System.out.print(max);
    }
}
