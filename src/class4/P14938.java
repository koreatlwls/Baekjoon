package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P14938 {

    static int n, m, r;
    static int max = Integer.MIN_VALUE;
    static int[] distance;
    static final int INF = (int) 1e9;
    static int[] items;
    static ArrayList<ArrayList<Node>> list;

    static class Node implements Comparable<Node> {
        int end;
        int dist;

        public Node(int end, int dist) {
            this.end = end;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node other) {
            if (this.dist < other.dist) {
                return -1;
            }
            return 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        items = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int input = Integer.parseInt(st.nextToken());
            items[i] = input;
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            list.get(a).add(new Node(b, l));
            list.get(b).add(new Node(a, l));
        }

        distance = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(distance, INF);
            dijkstra(i);

            int sum = 0;
            for (int j = 1; j <= n; j++) {
                if(distance[j]<=m){
                    sum += items[j];
                }
            }

            max = Math.max(max, sum);
        }

        System.out.print(max);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int dist = node.dist;
            int now = node.end;

            if (distance[now] < dist) continue;

            for (int i = 0; i < list.get(now).size(); i++) {
                int cost = distance[now] + list.get(now).get(i).dist;
                if (cost < distance[list.get(now).get(i).end]) {
                    distance[list.get(now).get(i).end] = cost;
                    pq.offer(new Node(list.get(now).get(i).end, cost));

                }
            }
        }
    }
}
