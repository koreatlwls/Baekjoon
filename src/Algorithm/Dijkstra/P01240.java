package Algorithm.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P01240 {

    static int N, M;
    static ArrayList<Node>[] list;
    static int[] dist;
    static boolean[] visited;

    static class Node implements Comparable<Node> {
        int n;
        int v;

        public Node(int n, int v) {
            this.n = n;
            this.v = v;
        }

        @Override
        public int compareTo(Node node) {
            return this.v - node.v;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            dist = new int[N + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            visited = new boolean[N + 1];
            dijkstra(start, end);
            sb.append(dist[end]).append("\n");
        }

        System.out.print(sb);
    }

    static void dijkstra(int s, int e) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[s] = 0;
        pq.offer(new Node(s, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (!visited[now.n]) visited[now.n] = true;
            else continue;

            for (int i = 0; i < list[now.n].size(); i++) {
                Node next = list[now.n].get(i);
                if (dist[next.n] > dist[now.n] + next.v) {
                    dist[next.n] = dist[now.n] + next.v;
                    pq.offer(new Node(next.n, dist[next.n]));
                }
            }
        }
    }
}
