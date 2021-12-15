package Algorithm.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P01759 {

    static int l, c;
    static char[] input;
    static char[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        input = new char[c];
        arr = new char[l];
        visited = new boolean[c];

        String[] a = br.readLine().split(" ");
        for (int i = 0; i < c; i++) {
            input[i] = a[i].charAt(0);
        }

        Arrays.sort(input);
        dfs(0, 0);
    }

    static void dfs(int at, int depth) {
        if (depth == l) {
            StringBuilder sb = new StringBuilder();
            int a_count = 0;
            int b_count = 0;

            for (char val : arr) {
                if (check(val)) {
                    a_count++;
                } else {
                    b_count++;
                }
                sb.append(val);
            }

            if (a_count >= 1 && b_count >= 2) {
                System.out.println(sb);
            }
            return;
        }

        for (int i = at; i < c; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = input[i];
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    static boolean check(char a) {
        if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u')
            return true;
        else
            return false;
    }
}
