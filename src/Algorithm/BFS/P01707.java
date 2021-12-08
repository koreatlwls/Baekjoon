package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P01707 {

    static int v, e;
    static ArrayList<ArrayList<Integer>> list;
    static int[] visited;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();
            for (int k = 0; k <= v; k++) {
                list.add(new ArrayList<>());
            }

            for (int j = 0; j < e; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                list.get(start).add(end);
                list.get(end).add(start);
            }

            flag = true;
            visited = new int[v + 1];
            bfs();
            String result = (flag) ? "YES" : "NO";
            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        for (int x = 1; x <= v; x++) {
            if (visited[x] == 0) {
                queue.offer(x);
                visited[x] = 1;
            }

            while (!queue.isEmpty()) {
                int now = queue.poll();

                for (int i = 0; i < list.get(now).size(); i++) {
                    if (visited[list.get(now).get(i)] == 0) {
                        visited[list.get(now).get(i)] = (visited[now] == 1) ? 2 : 1;
                        queue.offer(list.get(now).get(i));
                    } else if (visited[list.get(now).get(i)] == visited[now]) {
                        flag = false;
                    }
                }
            }
        }
    }
}
