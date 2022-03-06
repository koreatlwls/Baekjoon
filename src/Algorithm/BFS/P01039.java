package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P01039 {

    static int N, K;
    static int result = -1;

    static class Trade {
        int num;
        int cnt;

        public Trade(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs();
        System.out.print(result);
    }

    static void bfs() {
        Queue<Trade> queue = new LinkedList<>();
        boolean[][] visited = new boolean[1000001][K + 1];

        queue.add(new Trade(N, 0));
        visited[N][0] = true;

        while (!queue.isEmpty()) {
            Trade now = queue.poll();

            if (now.cnt == K) {
                result = Math.max(result, now.num);
                continue;
            }

            int len = String.valueOf(now.num).length();
            for (int i = 0; i < len - 1; i++) {
                for (int j = i + 1; j < len; j++) {
                    int next = swap(now.num, i, j);

                    if (next != -1 && !visited[next][now.cnt + 1]) {
                        queue.add(new Trade(next, now.cnt + 1));
                        visited[next][now.cnt + 1] = true;
                    }
                }
            }
        }
    }


    static int swap(int n, int i, int j) {
        char[] numArr = String.valueOf(n).toCharArray();

        if (i == 0 && numArr[j] == '0') {
            return -1;
        }

        char tmp = numArr[i];
        numArr[i] = numArr[j];
        numArr[j] = tmp;

        return Integer.parseInt(new String(numArr));
    }
}