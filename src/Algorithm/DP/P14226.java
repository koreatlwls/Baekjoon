package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P14226 {

    static int s;
    static boolean visited[][] = new boolean[1001][1001];

    static class Emotion {
        int clipboard;
        int screen;
        int second;

        public Emotion(int clipboard, int screen, int second) {
            this.clipboard = clipboard;
            this.screen = screen;
            this.second = second;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        s = Integer.parseInt(br.readLine());
        bfs();
    }

    static void bfs() {
        Queue<Emotion> queue = new LinkedList<>();
        queue.offer(new Emotion(0, 1, 0));
        visited[0][1] = true;

        while (!queue.isEmpty()) {
            Emotion now = queue.poll();

            if (now.screen == s) {
                System.out.print(now.second);
                return;
            }

            queue.offer(new Emotion(now.screen, now.screen, now.second + 1));

            if (now.clipboard != 0 && now.screen + now.clipboard <= s && !visited[now.clipboard][now.screen + now.clipboard]) {
                queue.offer(new Emotion(now.clipboard, now.screen + now.clipboard, now.second + 1));
                visited[now.clipboard][now.screen + now.clipboard] = true;
            }

            if (1 <= now.screen && !visited[now.clipboard][now.screen - 1]) {
                queue.offer(new Emotion(now.clipboard, now.screen - 1, now.second + 1));
                visited[now.clipboard][now.screen - 1] = true;
            }
        }
    }
}

