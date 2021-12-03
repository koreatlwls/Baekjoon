package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P11779 {

    static int n, m;
    static int start, end;
    static ArrayList<ArrayList<Node>> list;
    static final int INF = (int) 1e9;
    static int[] d;
    static int[] route;
    static StringBuilder sb = new StringBuilder();

    static class Node implements Comparable<Node> {
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            if (this.cost < other.cost) {
                return -1;
            }
            return 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        d = new int[n + 1];
        route = new int[n + 1];
        Arrays.fill(d, INF);
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list.get(a).add(new Node(b, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra(start, end);
        sb.append(d[end]).append("\n");

        Stack<Integer> stack = new Stack<>();
        while (true) {
            stack.push(end);
            end = route[end];
            if (end == start) {
                stack.push(end);
                break;
            }
        }
        sb.append(stack.size()).append("\n");

        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }

        System.out.print(sb);
    }

    static void dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        d[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.end;
            int cost = node.cost;

            if(now == end) break;
            if (d[now] < cost) continue;

            for (int i = 0; i < list.get(now).size(); i++) {
                int newCost = d[now] + list.get(now).get(i).cost;

                if (newCost < d[list.get(now).get(i).end]) {
                    d[list.get(now).get(i).end] = newCost;
                    route[list.get(now).get(i).end] = now;
                    pq.offer(new Node(list.get(now).get(i).end, newCost));
                }
            }
        }
    }
}
