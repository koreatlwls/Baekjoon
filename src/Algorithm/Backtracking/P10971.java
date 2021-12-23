package Algorithm.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10971 {

    static int n;
    static int[][] arr;
    static int min = Integer.MAX_VALUE;
    static int start = 0;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            start = i;
            solve(i, i, 0, 0);
        }
        System.out.println(min);
    }

    static void solve(int x, int y, int cnt, int sum) {
        if (cnt == n && start == y) {
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            if (arr[y][i] == 0) continue;
            if (sum + arr[y][i] > min) continue;

            visited[i] = true;
            solve(y, i, cnt + 1, sum + arr[y][i]);
            visited[i] = false;
        }
    }
}
