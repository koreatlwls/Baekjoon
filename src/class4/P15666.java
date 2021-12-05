package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P15666 {

    static int n, m;
    static int[] input;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        input = new int[n];
        arr = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);
        dfs(0, 0);
        System.out.print(sb);
    }

    static void dfs(int at, int depth) {
        StringBuilder sb2 = new StringBuilder();
        if (depth == m) {
            for (int val : arr) {
                sb2.append(val).append(' ');
            }
            if (!set.contains(sb2.toString())) {
                sb.append(sb2.toString()).append("\n");
                set.add(sb2.toString());
            }
            return;
        }

        for (int i = at; i < n; i++) {
            arr[depth] = input[i];
            dfs(i, depth + 1);
        }
    }
}
