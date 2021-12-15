package Algorithm.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P01182 {

    static int n, s;
    static int[] input;
    static boolean[] visited;
    static int count = 0;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        input = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            arr = new int[i];
            dfs(0, 0, i);
        }

        System.out.print(count);
    }

    static void dfs(int at, int depth, int max) {
        if (depth == max) {
            int sum = 0;

            for (int val : arr) {
                sum += val;
            }

            if (sum == s) {
                count++;
            }

            return;
        }

        for (int i = at; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = input[i];
                dfs(i + 1, depth + 1, max);
                visited[i] = false;
            }
        }
    }
}
