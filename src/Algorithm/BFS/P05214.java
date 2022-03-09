package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P05214 {

    static int N, K, M;
    static ArrayList<Integer>[] transferStation;
    static HashSet<Integer> destStation;
    static ArrayList<Integer>[] line;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        destStation = new HashSet<>();
        line = new ArrayList[M + 1];
        transferStation = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            transferStation[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            line[i] = new ArrayList<>();

            for (int j = 0; j < K; j++) {
                int num = Integer.parseInt(st.nextToken());

                transferStation[num].add(i);

                if (num == N) {
                    destStation.add(i);
                }
            }
        }

        for (int i = 0; i <= N; i++) {
            if (transferStation[i].size() > 1) {
                for (int t : transferStation[i]) {
                    line[t].add(i);
                }
            }
        }

        System.out.print(bfs());
    }

    static int bfs() {
        if (N == 1) return 1;
        boolean[] visited = new boolean[M + 1];
        Queue<Integer> queue = new LinkedList<>();
        for (int num : transferStation[1]) {
            queue.add(num);
            visited[num] = true;
        }

        int hop = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int poll = queue.poll();
                if (destStation.contains(poll)) {
                    return hop + 1;
                }

                for (int num : line[poll]) {
                    if (!transferStation[num].isEmpty()) {
                        for (int i : transferStation[num]) {
                            if (!visited[i]) {
                                visited[i] = true;
                                queue.add(i);
                            }
                        }
                        transferStation[num].clone();
                    }
                }
            }
            hop++;
        }

        return -1;
    }
}
