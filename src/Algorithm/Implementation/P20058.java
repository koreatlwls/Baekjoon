package Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P20058 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
        int Q = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] L = new int[Q];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            L[i] = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
        }

        process(N, Q, map, L);

        int[] res = findLump(map, N);

        System.out.println(res[0]);
        System.out.println(res[1]);
    }

    static void process(int n, int q, int[][] map, int[] l) {
        for (int i = 0; i < q; i++) {
            int level = l[i];
            rotate(map, level, n, 0, 0);
            meltIce(map, n);
        }
    }

    private static int[] findLump(int[][] map, int n) {
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        boolean[][] visited = new boolean[n][n];
        int sum = 0;
        int lump = 0;
        int max_lump = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += map[i][j];
                if (map[i][j] == 0) continue;
                if (visited[i][j]) continue;
                Queue<int[]> ice_queue = new LinkedList<int[]>();
                ice_queue.offer(new int[]{i, j});
                visited[i][j] = true;
                lump = 0;

                while (!ice_queue.isEmpty()) {
                    int[] cur_ice = ice_queue.poll();
                    int y = cur_ice[0];
                    int x = cur_ice[1];
                    lump++;

                    for (int d = 0; d < 4; d++) {
                        int next_y = y + dy[d];
                        int next_x = x + dx[d];

                        if (rangeCheck(next_y, next_x, n)) continue;
                        if (map[next_y][next_x] == 0) continue;
                        if (visited[next_y][next_x]) continue;
                        ice_queue.offer(new int[]{next_y, next_x});
                        visited[next_y][next_x] = true;
                    }
                }

                max_lump = max_lump > lump ? max_lump : lump;
            }
        }
        int[] res = {sum, max_lump};
        return res;
    }

    static void meltIce(int[][] map, int n) {
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        List<int[]> list = new LinkedList<int[]>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) continue;


                int ice_cnt = 4;
                for (int d = 0; d < 4; d++) {
                    int next_y = i + dy[d];
                    int next_x = j + dx[d];
                    if (rangeCheck(next_y, next_x, n)) {
                        ice_cnt--;
                        continue;
                    }
                    if (map[next_y][next_x] == 0) {
                        ice_cnt--;
                        continue;
                    }
                }

                if (ice_cnt <= 2) {
                    list.add(new int[]{i, j});
                }
            }
        }

        for (int[] position : list) {
            int y = position[0];
            int x = position[1];
            if (map[y][x] > 0) {
                map[y][x]--;
            }
        }
    }

    static boolean rangeCheck(int next_y, int next_x, int n) {
        return next_y < 0 || next_y >= n || next_x < 0 || next_x >= n;
    }

    private static void rotate(int[][] map, int l, int n, int y, int x) {
        if (n == l) {
            int[][] init_map = new int[n][n];
            int idx_y = 0;
            for (int i = y; i < n + y; i++) {
                int idx_x = 0;
                for (int j = x; j < n + x; j++) {
                    init_map[idx_y][idx_x++] = map[i][j];
                }
                idx_y++;
            }

            idx_y = 0;
            for (int i = y; i < n + y; i++) {
                int idx_x = 0;
                for (int j = x; j < n + x; j++) {
                    map[i][j] = init_map[n - 1 - idx_x++][idx_y];
                }
                idx_y++;
            }

            return;
        }

        rotate(map, l, n / 2, y, x);
        rotate(map, l, n / 2, y, x + n / 2);
        rotate(map, l, n / 2, y + n / 2, x);
        rotate(map, l, n / 2, y + n / 2, x + n / 2);
    }
}