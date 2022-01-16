package Algorithm.Kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P06497 {

    static int[] parent;

    static class Road implements Comparable<Road> {
        int start;
        int end;
        int weight;

        public Road(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Road o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            if (m == 0 && n == 0) {
                break;
            }

            ArrayList<Road> list = new ArrayList<>();
            int totalCost = 0;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                list.add(new Road(a, b, c));
                totalCost += c;
            }
            Collections.sort(list);

            parent = new int[m];
            for (int i = 0; i < m; i++) {
                parent[i] = i;
            }

            int minCost = 0;
            for (int i = 0; i < list.size(); i++) {
                Road now = list.get(i);

                if (find(now.start) != find(now.end)) {
                    minCost += now.weight;
                    union(now.start, now.end);
                }
            }

            sb.append(totalCost - minCost).append("\n");
        }

        System.out.print(sb);
    }

    static int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
        }
    }
}
