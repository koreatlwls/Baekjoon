package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P01967 {

    static int n;
    static int max = Integer.MIN_VALUE;
    static int max_idx = Integer.MIN_VALUE;
    static boolean[] visited;
    static ArrayList<ArrayList<Node>> list;

    static class Node {
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list.get(start).add(new Node(end, cost));
            list.get(end).add(new Node(start, cost));
        }

        visited = new boolean[n + 1];
        visited[1] = true;
        dfs(1, 0);

        visited = new boolean[n + 1];
        visited[max_idx] = true;
        dfs(max_idx, 0);
        System.out.println(max);
    }

    static void dfs(int idx, int cnt) {
        if (max < cnt) {
            max = cnt;
            max_idx = idx;
        }

        for (Node a : list.get(idx)) {
            if (!visited[a.end]) {
                visited[a.end] = true;
                dfs(a.end, cnt + a.cost);
            }
        }
    }
}
