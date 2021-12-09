package Algorithm.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P09370 {

    static int n, m, t;
    static int s, g, h;
    static ArrayList<ArrayList<Node>> list;
    static int[] dist;
    static final int INF = (int) 1e9;
    static int[] candidate;
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
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            dist = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                dist[i] = INF;
            }

            list = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                list.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                if ((a == g && b == h) || (a == h && b == g)) {
                    list.get(a).add(new Node(b, d * 2 - 1));
                    list.get(b).add(new Node(a, d * 2 - 1));
                } else {
                    list.get(a).add(new Node(b, d * 2));
                    list.get(b).add(new Node(a, d * 2));
                }
            }

            candidate = new int[t];
            for (int i = 0; i < t; i++) {
                candidate[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(candidate);
            dijkstra();
        }

        System.out.print(sb);
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(s, 0));
        dist[s] = 0;

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

        for(int i=0;i<t;i++){
            if(dist[candidate[i]] % 2 == 1){
                sb.append(candidate[i]).append(" ");
            }
        }
        sb.append("\n");
    }
}
