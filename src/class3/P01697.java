package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P01697 {

    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        int result = 0;
        if (N > K) {
            result = N - K;
        } else {
            result = bfs(N, K);
        }
        System.out.print(result);
    }

    public static int bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int x = queue.poll();
                if (x == end) {
                    return count;
                }

                if (x - 1 >= 0 && !visited[x - 1]) {
                    visited[x - 1] = true;
                    queue.offer(x - 1);
                }
                if (x + 1 <= 100000 && !visited[x + 1]) {
                    visited[x + 1] = true;
                    queue.offer(x + 1);
                }
                if (2 * x <= 100000 && !visited[2 * x]) {
                    visited[2 * x] = true;
                    queue.offer(x * 2);
                }

            }
            count++;
        }

        return count;
    }
}
