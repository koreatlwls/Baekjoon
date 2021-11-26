package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P01916 {

    static int n, m;
    static int dist[];
    static final int INF = (int) 1e9;
    static ArrayList<ArrayList<Edge>> list;

    static class Edge {
        int end;
        int weight;

        public Edge(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());


        dist = new int[n + 1];
        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list.get(start).add(new Edge(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        int startBus = Integer.parseInt(st.nextToken());
        int endBus = Integer.parseInt(st.nextToken());

        dijkstra(startBus, endBus);
    }

    static void dijkstra(int s, int e) {
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(dist, INF);
        dist[s] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
        pq.offer(new Edge(s, 0));

        while (!pq.isEmpty()) {
            Edge curEdge = pq.poll();

            if (curEdge.end == e) {
                System.out.print(dist[e]);
                return;
            }

            if (dist[curEdge.end] < curEdge.weight) {
                continue;
            }

            for (int i = 0; i < list.get(curEdge.end).size(); i++) {
                Edge nxtEdge = list.get(curEdge.end).get(i);
                if (dist[nxtEdge.end] > curEdge.weight + nxtEdge.weight) {
                    dist[nxtEdge.end] = curEdge.weight + nxtEdge.weight;
                    pq.offer(new Edge(nxtEdge.end, dist[nxtEdge.end]));
                }
            }
        }
    }
}
