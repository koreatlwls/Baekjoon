package Algorithm.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P16964 {

    static int n, idx = 1;
    static boolean[] visited;
    static boolean correct = true;
    static ArrayList<Integer> arr;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        arr = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        if (arr.get(0) != 1) {
            System.out.print(0);
        } else {
            visited[1] = true;
            dfs(1);
            if (correct) {
                System.out.print(1);
            } else {
                System.out.print(0);
            }
        }
    }

    static void dfs(int cur) {
        if (!correct) {
            return;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int next : list[cur]) {
            if (!visited[next]) {
                visited[next] = true;
                set.add(next);
            }
        }

        int size = set.size();
        for (int i = 0; i < size; i++) {
            if (set.remove(arr.get(idx))) {
                dfs(arr.get(idx++));
            } else {
                correct = false;
                return;
            }
        }
    }
}
