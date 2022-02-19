package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class P13913 {

    static int N, K;
    static int time;
    static boolean[] visited = new boolean[100001];
    static int[] parent = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(N == K){
            sb.append(0).append("\n");
            sb.append(N).append("\n");
        }else {
            bfs(N);
            sb.append(time).append("\n");

            Stack<Integer> stack = new Stack<>();
            stack.add(K);
            int index = K;
            while (index != N) {
                stack.push(parent[index]);
                index = parent[index];
            }

            while (!stack.isEmpty()) {
                sb.append(stack.pop()).append(" ");
            }
        }
        System.out.println(sb);
    }

    static void bfs(int start) {
        time = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            if(visited[K]) {
                return;
            }

            for(int j = 0, size = queue.size(); j < size; j++) {
                int now = queue.poll();
                int next;

                next = now - 1;
                if(next >= 0 && !visited[next]) {
                    visited[next] = true;
                    parent[next] = now;
                    queue.offer(next);
                }

                next = now + 1;
                if(next < 100001 && !visited[next]) {
                    visited[next] = true;
                    parent[next] = now;
                    queue.offer(next);
                }

                next = now * 2;
                if(next < 100001 && !visited[next]) {
                    visited[next] = true;
                    parent[next] = now;
                    queue.offer(next);
                }
            }
            time++;
        }
    }
}