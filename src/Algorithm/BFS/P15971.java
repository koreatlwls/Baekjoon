package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P15971 {

    static ArrayList<Node>[] tree;
    static int n;

    static class Node {
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }

    static class Pair {
        int x;
        int cost;
        int max;

        public Pair(int x, int cost, int max) {
            this.x = x;
            this.cost = cost;
            this.max = max;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int robot1 = Integer.parseInt(st.nextToken());
        int robot2 = Integer.parseInt(st.nextToken());

        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            tree[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            tree[start].add(new Node(end, cost));
            tree[end].add(new Node(start, cost));
        }

        bfs(robot1, robot2);
    }

    static void bfs(int robot1, int robot2) {
        Queue<Pair> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        visited[robot1] = true;
        queue.add(new Pair(robot1, 0, 0));

        while (!queue.isEmpty()) {
            Pair temp = queue.poll();

            if (temp.x == robot2) {
                System.out.println(temp.cost - temp.max);
                break;
            }

            for (Node n : tree[temp.x]) {
                if (!visited[n.end]) {
                    visited[n.end] = true;
                    queue.add(new Pair(n.end, temp.cost + n.cost, Math.max(temp.max, n.cost)));
                }
            }
        }
    }
}