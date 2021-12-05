package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P17144 {

    static int r, c, t;
    static int[][] arr = new int[50][50];
    static int sumDust = 2;
    static List<Integer> airCleanerRows = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                sumDust += arr[i][j];

                if (arr[i][j] == -1) {
                    airCleanerRows.add(i);
                }
            }
        }

        solution();
    }

    static void solution() {
        while (t-- > 0) {
            arr = spreadDust();
            executeAirCleaner();
        }
        System.out.println(calculateSum());
    }

    static int[][] spreadDust() {
        int[][] temp = new int[50][50];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int x = 0; x < r; x++) {
            for (int y = 0; y < c; y++) {
                if (arr[x][y] == -1) {
                    temp[x][y] = -1;
                    continue;
                }

                temp[x][y] += arr[x][y];

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                    if (arr[nx][ny] == -1) continue;

                    temp[nx][ny] += (arr[x][y] / 5);
                    temp[x][y] -= (arr[x][y] / 5);
                }
            }
        }

        return temp;
    }

    static void executeAirCleaner() {
        int top = airCleanerRows.get(0);

        for (int x = top - 1; x > 0; x--) {
            arr[x][0] = arr[x - 1][0];
        }

        for (int y = 0; y < c - 1; y++) {
            arr[0][y] = arr[0][y + 1];
        }

        for (int x = 0; x < top; x++) {
            arr[x][c - 1] = arr[x + 1][c - 1];
        }

        for (int y = c - 1; y > 1; y--) {
            arr[top][y] = arr[top][y - 1];
        }

        arr[top][1] = 0;

        int bottom = airCleanerRows.get(1);

        for (int x = bottom + 1; x < r - 1; x++) {
            arr[x][0] = arr[x + 1][0];
        }

        for (int y = 0; y < c - 1; y++) {
            arr[r - 1][y] = arr[r - 1][y + 1];
        }

        for (int x = r - 1; x > bottom; x--) {
            arr[x][c - 1] = arr[x - 1][c - 1];
        }

        for (int y = c - 1; y > 1; y--) {
            arr[bottom][y] = arr[bottom][y - 1];
        }

        arr[bottom][1] = 0;
    }

    static int calculateSum() {
        int sum = 2;

        for (int x = 0; x < r; x++) {
            for (int y = 0; y < c; y++) {
                sum += arr[x][y];
            }
        }

        return sum;
    }
}
