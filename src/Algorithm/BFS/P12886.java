package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P12886 {

    static boolean flag = false;
    static boolean[][] visited;
    static Stone stone;

    static class Stone {
        int a, b, c;

        public Stone(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if ((a + b + c) % 3 != 0) {
            System.out.print(0);
            return;
        }

        visited = new boolean[1501][1501];
        stone = new Stone(a, b, c);
        bfs();

        if (flag) {
            System.out.print(1);
        } else {
            System.out.print(0);
        }
    }

    static void bfs() {
        Queue<Stone> queue = new LinkedList<>();
        queue.add(stone);
        visited[stone.a][stone.b] = true;

        while (!queue.isEmpty()) {
            Stone now = queue.poll();
            if (now.a == now.b && now.b == now.c) {
                flag = true;
                break;
            }

            if (now.a != now.b) {
                if (now.a < now.b) {
                    if (!visited[now.a + now.a][now.b - now.a]) {
                        queue.add(new Stone(now.a + now.a, now.b - now.a, now.c));
                        visited[now.a + now.a][now.b - now.a] = true;
                    }
                } else if (now.a > now.b) {
                    if (!visited[now.a - now.b][now.b + now.b]) {
                        queue.add(new Stone(now.a - now.b, now.b + now.b, now.c));
                        visited[now.a - now.b][now.b + now.b] = true;
                    }
                }
            }
            if (now.a != now.c) {
                if (now.a < now.c) {
                    if (!visited[now.a + now.a][now.c - now.a]) {
                        queue.add(new Stone(now.a + now.a, now.b, now.c - now.a));
                        visited[now.a + now.a][now.c - now.a] = true;
                    }
                } else if (now.a > now.c) {
                    if (!visited[now.a - now.c][now.c + now.c]) {
                        queue.add(new Stone(now.a - now.c, now.b, now.c + now.c));
                        visited[now.a - now.c][now.c + now.c] = true;
                    }
                }
            }
            if (now.b != now.c) {
                if (now.b < now.c) {
                    if (!visited[now.b + now.b][now.c - now.b]) {
                        queue.add(new Stone(now.a, now.b + now.b, now.c - now.b));
                        visited[now.b + now.b][now.c - now.b] = true;
                    }
                } else if (now.b > now.c) {
                    if (!visited[now.b - now.c][now.c + now.c]) {
                        queue.add(new Stone(now.a, now.b - now.c, now.c + now.c));
                        visited[now.b - now.c][now.c + now.c] = true;
                    }
                }

            }
        }
    }
}
