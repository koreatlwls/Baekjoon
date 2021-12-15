package Algorithm.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15649 {

    static int n, m;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        visited = new boolean[n + 1];

        dfs(1, 0);

        System.out.print(sb);
    }

    static void dfs(int at, int depth) {

        if (depth == m) {
            for (int val : arr) {
                sb.append(val + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                dfs(i , depth + 1);
                visited[i] = false;
            }

        }
    }
}
