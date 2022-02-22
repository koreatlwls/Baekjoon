package Algorithm.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P16938 {

    static int N, L, R, X;
    static int[] grade;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        grade = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            grade[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, -1, 1000001, 0, 0);
        System.out.print(ans);
    }

    static void dfs(int idx, int max, int min, int sum, int cnt) {
        if (cnt >= 2) {
            if (sum >= L && sum <= R && max - min >= X) {
                ans++;
            }
        }

        if (idx == N) return;

        for (int i = idx; i < N; i++) {
            dfs(i + 1, Math.max(max, grade[i]), Math.min(min, grade[i]), sum + grade[i], cnt + 1);
        }
    }
}
