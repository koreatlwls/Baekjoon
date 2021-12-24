package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P01963 {

    static int[] inputs;
    static boolean[] prime = new boolean[10000];
    static int answer;

    static class Prime {
        int num;
        int cnt;

        public Prime(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        public int get1() {
            return num % 10;
        }

        public int get2() {
            return (num % 100) / 10;
        }

        public int get3() {
            return (num % 1000) / 100;
        }

        public int get4() {
            return (num) / 1000;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        isPrime();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            inputs = new int[2];
            inputs[0] = Integer.parseInt(st.nextToken());
            inputs[1] = Integer.parseInt(st.nextToken());

            answer = Integer.MAX_VALUE;
            sb.append(bfs() == Integer.MAX_VALUE ? "Impossible" : answer).append("\n");
        }

        System.out.print(sb);
    }

    static void isPrime() {
        prime[0] = prime[1] = true;

        for (int i = 2; i * i < 10000; i++) {
            if (!prime[i]) {
                for (int j = i * i; j < 10000; j += i) {
                    prime[j] = true;
                }
            }
        }
    }

    static int bfs() {
        boolean[] visited = new boolean[10000];
        visited[inputs[0]] = true;
        Queue<Prime> queue = new LinkedList<>();
        queue.add(new Prime(inputs[0], 0));

        while (!queue.isEmpty()) {
            Prime now = queue.poll();

            if (now.num == inputs[1]) {
                answer = Math.min(answer, now.cnt);
            }

            for (int i = 0; i < 10; i++) {
                if (i != now.get4()) {
                    int next = i * 1000 + now.get3() * 100 + now.get2() * 10 + now.get1();
                    if (1000 <= next && !prime[next] && !visited[next]) {
                        visited[next] = true;
                        queue.offer(new Prime(next, now.cnt + 1));
                    }
                }

                if (i != now.get3()) {
                    int next = now.get4() * 1000 + i * 100 + now.get2() * 10 + now.get1();
                    if (1000 <= next && !prime[next] && !visited[next]) {
                        visited[next] = true;
                        queue.offer(new Prime(next, now.cnt + 1));
                    }
                }

                if (i != now.get2()) {
                    int next = now.get4() * 1000 + now.get3() * 100 + i * 10 + now.get1();
                    if (1000 <= next && !prime[next] && !visited[next]) {
                        visited[next] = true;
                        queue.offer(new Prime(next, now.cnt + 1));
                    }
                }

                if (i != now.get1()) {
                    int next = now.get4() * 1000 + now.get3() * 100 + now.get2() * 10 + i;
                    if (1000 <= next && !prime[next] && !visited[next]) {
                        visited[next] = true;
                        queue.offer(new Prime(next, now.cnt + 1));
                    }
                }
            }
        }

        return answer;
    }
}
