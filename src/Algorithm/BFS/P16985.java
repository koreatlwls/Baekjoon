package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P16985 {

    static int[][][] map = new int[5][5][5];
    static int[][][] origin = new int[5][5][5];
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int min = Integer.MAX_VALUE;

    static class Pair {
        int x;
        int y;
        int z;
        int cnt;

        public Pair(int x, int y, int z, int cnt) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 5; k++) {
                    origin[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[5];
        perm(visited, list);

        if (min == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(min);
    }

    static void perm(boolean[] visited, ArrayList<Integer> list) {
        if (list.size() == 5) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 5; k++) {
                        map[i][j][k] = origin[list.get(i)][j][k];
                    }
                }
            }
            if (min != 12)
                sol();
            return;
        }

        for (int i = 0; i < 5; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(i);
                perm(visited, list);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    static int bfs() {
        Queue<Pair> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[5][5][5];
        int cnt = Integer.MAX_VALUE;

        visited[0][0][0] = true;
        queue.add(new Pair(0, 0, 0, 0));

        while (!queue.isEmpty()) {
            Pair temp = queue.poll();

            if (temp.x == 4 && temp.y == 4 && temp.z == 4) {
                cnt = temp.cnt;
                break;
            }

            for (int i = 0; i < 6; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                int nz = temp.z + dz[i];

                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || nz < 0 || nz >= 5 || visited[nz][nx][ny] || map[nz][nx][ny] == 0)
                    continue;

                visited[nz][nx][ny] = true;
                queue.add(new Pair(nx, ny, nz, temp.cnt + 1));
            }
        }
        return cnt;
    }

    static void sol() {
        if (map[0][0][0] == 1 && map[4][4][4] == 1) {
            int dist = bfs();
            min = Math.min(min, dist);
        }

        for (int a = 0; a < 4; a++) {
            rotate(0);
            for (int b = 0; b < 4; b++) {
                rotate(1);
                for (int c = 0; c < 4; c++) {
                    rotate(2);
                    for (int d = 0; d < 4; d++) {
                        rotate(3);
                        for (int e = 0; e < 4; e++) {
                            rotate(4);
                            if (map[0][0][0] == 1 && map[4][4][4] == 1) {
                                int dist = bfs();
                                min = Math.min(min, dist);
                            }
                        }
                    }
                }
            }
        }
    }

    static void rotate(int z) {
        int[][] temp = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                temp[j][4 - i] = map[z][i][j];
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                map[z][i][j] = temp[i][j];
            }
        }
    }
}
