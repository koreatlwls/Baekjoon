package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P02573 {

    static int n, m;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class IceBerg {
        int x;
        int y;

        IceBerg(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        int cnt = 0;

        while ((cnt = SeparateNum()) < 2) {
            if (cnt == 0) {
                ans = 0;
                break;
            }

            Melt();
            ans++;
        }

        System.out.print(ans);
    }

    public static int SeparateNum() {
        boolean[][] visited = new boolean[n][m];

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    DFS(i, j, visited);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void DFS(int x, int y, boolean[][] visited) {
        visited[x][y] = true;

        int dx, dy;
        for (int i = 0; i < 4; i++) {
            dx = x + dr[i];
            dy = y + dc[i];

            if (dx < 0 || dy < 0 || dx >= n || dy >= m) {
                continue;
            }

            if (map[dx][dy] != 0 && !visited[dx][dy]) {
                DFS(dx, dy, visited);
            }
        }
    }

    public static void Melt() {
        Queue<IceBerg> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0) {
                    q.offer(new IceBerg(i, j));
                    visited[i][j] = true;
                }
            }
        }

        int dx, dy;
        while (!q.isEmpty()) {
            IceBerg ice = q.poll();

            int seaNum = 0;

            for (int i = 0; i < 4; i++) {
                dx = ice.x + dr[i];
                dy = ice.y + dc[i];

                if (dx < 0 || dy < 0 || dx >= n || dy >= m) {
                    continue;
                }

                if (!visited[dx][dy] && map[dx][dy] == 0) {
                    seaNum++;
                }
            }

            if (map[ice.x][ice.y] - seaNum < 0) {
                map[ice.x][ice.y] = 0;
            } else {
                map[ice.x][ice.y] -= seaNum;
            }
        }
    }
}
