package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P12851 {

    static int n, k;
    static int count = 0;
    static int minTime = Integer.MAX_VALUE;
    static int[] time = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n >= k) {
            System.out.println((n - k) + "\n1");
            return;
        }

        bfs();
        System.out.println(minTime + "\n" + count);
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        time[n] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (minTime < time[now]) return;

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0) next = now - 1;
                else if (i == 1) next = now + 1;
                else next = now * 2;

                if (next < 0 || next > 100000) continue;

                if (next == k) {
                    minTime = time[now];
                    count++;
                }

                if (time[next] == 0 || time[next] == time[now] + 1) {
                    queue.offer(next);
                    time[next] = time[now] + 1;
                }
            }
        }
    }
}
