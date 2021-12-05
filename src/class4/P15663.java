package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P15663 {

    static int n, m;
    static int[] input;
    static int[] arr;
    static boolean[] visited;
    static HashSet<String> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        input = new int[n];
        visited = new boolean[n];
        arr = new int[m];
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);

        dfs(0);
        System.out.print(sb);
    }

    static void dfs(int depth) {
        if (depth == m) {
            StringBuilder sb2 = new StringBuilder();
            for (int val : arr) {
                sb2.append(val).append(" ");
            }
            if (!set.contains(sb2.toString())) {
                sb.append(sb2.toString()).append("\n");
                set.add(sb2.toString());
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                arr[depth] = input[i];
                visited[i] = true;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
