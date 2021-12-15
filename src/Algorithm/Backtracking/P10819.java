package Algorithm.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10819 {

    static int n;
    static int[] input;
    static boolean[] visited;
    static int[] arr;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        input = new int[n];
        visited = new boolean[n];
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0);

        System.out.print(result);
    }

    static void dfs(int count) {
        if (count == n) {
            result = Math.max(result, getResult());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[count] = input[i];
                dfs(count + 1);
                visited[i] = false;
            }
        }
    }

    static int getResult() {
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += Math.abs(arr[i] - arr[i + 1]);
        }

        return sum;
    }
}
