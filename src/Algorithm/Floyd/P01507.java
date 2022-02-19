package Algorithm.Floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P01507 {
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] dist = new int[N + 1][N + 1];
        int[][] arr = new int[N + 1][N + 1];
        boolean[][] check = new boolean[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
                arr[i][j] = dist[i][j];
            }
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i == j || i == k || k == j) {
                        continue;
                    }

                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        System.out.println(-1);
                        return;
                    }

                    if (dist[i][j] == dist[i][k] + dist[k][j]) {
                        arr[i][j] = INF;
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (arr[i][j] != INF && i != j && !check[i][j]) {
                    ans += arr[i][j];
                    check[i][j] = check[j][i] = true;
                }
            }
        }

        System.out.println(ans);
    }

}