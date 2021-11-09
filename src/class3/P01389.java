package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P01389 {

    static int map[][];
    static boolean visited[];
    static StringTokenizer st;
    static int N, M, start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int min = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            map[start][end] = 1;
            map[end][start] = 1;
        }

        int num = 0;
        for (int i = 1; i <= N; i++) {
            int value = bfs(i);
            if (min > value) {
                min = value;
                num = i;
            }
            visited = new boolean[N + 1];
        }
        System.out.print(num);
    }

    static int bfs(int point) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(point);
        visited[point] = true;
        int count = 0;
        int result = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int x = queue.poll();
                for (int j = 1; j <= N; j++) {
                    if (map[x][j] == 1 && visited[j] == false) {
                        queue.offer(j);
                        visited[j] = true;
                    }
                }
                result += count;
            }
            count++;
        }
        return result;
    }
}
