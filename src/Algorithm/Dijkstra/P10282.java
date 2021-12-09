package Algorithm.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P10282 {

    static int n, d, c;
    static ArrayList<ArrayList<Node>> list;
    static int[] dist;
    static final int INF = (int) 1e9;
    static StringBuilder sb = new StringBuilder();

    static class Node implements Comparable<Node> {
        int end;
        int dist;

        public Node(int end, int dist) {
            this.end = end;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                list.add(new ArrayList<>());
            }

            dist = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                dist[i] = INF;
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                list.get(b).add(new Node(a, s));
            }

            dijkstra();
        }

        System.out.print(sb);
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(c, 0));
        dist[c] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (dist[now.end] < now.dist) continue;

            for (int i = 0; i < list.get(now.end).size(); i++) {
                int cost = dist[now.end] + list.get(now.end).get(i).dist;
                if (cost < dist[list.get(now.end).get(i).end]) {
                    dist[list.get(now.end).get(i).end] = cost;
                    pq.offer(new Node(list.get(now.end).get(i).end, cost));
                }
            }
        }

        int max = Integer.MIN_VALUE;
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] != INF) {
                max = Math.max(max, dist[i]);
                cnt++;
            }
        }

        sb.append(cnt + " " + max).append("\n");
    }
}
