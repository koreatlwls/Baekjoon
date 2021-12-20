package Algorithm.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P13023 {

    static int n, m;
    static ArrayList<ArrayList<Integer>> list;
    static int ans = 0;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        for (int i = 0; i < n; i++) {
            if (ans == 0) {
                dfs(i, 1);
            }
        }

        System.out.print(ans);
    }

    static void dfs(int start, int depth) {
        if (depth == 5) {
            ans = 1;
            return;
        }

        visited[start] = true;
        for (int i : list.get(start)) {
            int next = i;
            if (!visited[next]) {
                dfs(next, depth + 1);
            }
        }
        visited[start] = false;
    }
}
