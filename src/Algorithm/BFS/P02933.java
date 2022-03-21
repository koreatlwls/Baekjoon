package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P02933 {

    static class Loc {
        int i;
        int j;

        public Loc(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static int R, C, N;
    static char[][] map;
    static int[][] clusters;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int bar = Integer.parseInt(st.nextToken());
            destructMineral(bar, i % 2 == 0 ? 1 : 2);
            setCluster();
        }

        for (int i = 0; i < R; i++) {
            System.out.println(map[i]);
        }

    }

    static void destructMineral(int height, int direction) {
        if (direction == 1) {
            for (int col = 0; col < C; col++) {
                if (map[R - height][col] == 'x') {
                    map[R - height][col] = '.';
                    return;
                }
            }
        } else {
            for (int col = C - 1; col >= 0; col--) {
                if (map[R - height][col] == 'x') {
                    map[R - height][col] = '.';
                    return;
                }
            }
        }
    }

    static void setCluster() {
        clusters = new int[R][C];

        int cluster_num = 1;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'x' && clusters[i][j] == 0) {
                    if (findCluster(i, j, cluster_num)) {
                        return;
                    }
                    cluster_num++;
                }
            }
        }
    }

    static boolean findCluster(int i, int j, int cluster_num) {
        int[] mi = {0, 0, -1, 1};
        int[] mj = {1, -1, 0, 0};

        int lowest = -1;

        Queue<Loc> q = new LinkedList<>();
        ArrayList<Loc> arr = new ArrayList<>();

        q.add(new Loc(i, j));
        clusters[i][j] = cluster_num;

        while (!q.isEmpty()) {
            Loc now = q.poll();

            lowest = Math.max(lowest, now.i);

            for (int d = 0; d < 4; d++) {
                int ni = now.i + mi[d];
                int nj = now.j + mj[d];

                if (ni < 0 || nj < 0 || ni >= R || nj >= C) continue;

                if (clusters[ni][nj] == 0 && map[ni][nj] == 'x') {
                    clusters[ni][nj] = cluster_num;
                    q.add(new Loc(ni, nj));
                }
            }
            arr.add(now);
        }

        if (lowest != R - 1) {
            moveCluster(arr);
            return true;
        }
        return false;
    }

    static void moveCluster(ArrayList<Loc> arr) {
        int move = 1;

        for (Loc loc : arr) {
            map[loc.i][loc.j] = '.';
        }

        outerLoop:
        while (true) {
            for (Loc loc : arr) {
                if (loc.i + move == R || map[loc.i + move][loc.j] == 'x') {
                    move--;
                    break outerLoop;
                }
            }
            move++;
        }

        for (Loc loc : arr) {
            map[loc.i + move][loc.j] = 'x';
        }
    }
}
