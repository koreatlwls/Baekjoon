package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P05014 {

    static int F, S, G, U, D;
    static boolean[] visited;
    static int[] updown;

    static class Elevator {
        int now;
        int cnt;

        public Elevator(int now, int cnt) {
            this.now = now;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visited = new boolean[F + 1];
        updown = new int[2];
        updown[0] = U;
        updown[1] = -D;

        int result = bfs();
        if (result != -1) {
            System.out.println(result);
        } else {
            System.out.println("use the stairs");
        }
    }

    static int bfs() {
        Queue<Elevator> queue = new LinkedList<>();
        queue.add(new Elevator(S, 0));
        visited[S] = true;

        while (!queue.isEmpty()) {
            Elevator now = queue.poll();

            if (now.now == G) {
                return now.cnt;
            }

            for (int i = 0; i < 2; i++) {
                int nextNow = now.now + updown[i];

                if (1 <= nextNow && nextNow <= F && !visited[nextNow]) {
                    queue.add(new Elevator(nextNow, now.cnt + 1));
                    visited[nextNow] = true;
                }
            }
        }

        return -1;
    }
}
