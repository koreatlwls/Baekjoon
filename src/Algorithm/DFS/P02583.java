package Algorithm.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class P02583 {

    static int m, n, k;
    static int[][] map;
    static boolean[][] visited;
    static int count;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int r1 = m - y2;
            int r2 = m - y1 - 1;
            int c1 = x1;
            int c2 = x2 - 1;

            for (int r = r1; r <= r2; r++) {
                for (int c = c1; c <= c2; c++) {
                    map[r][c] = 1;
                }
            }
        }

        solution();
        Collections.sort(list);
        sb.append(list.size() + "\n");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i) + " ");
        }
        System.out.print(sb);
    }

    static void solution() {
        for (int curR = 0; curR < m; curR++) {
            for (int curC = 0; curC < n; curC++) {
                if (map[curR][curC] == 0 && !visited[curR][curC]) {
                    count = 0;
                    dfs(curR, curC);
                    list.add(count);
                }
            }
        }
    }

    static void dfs(int curR, int curC) {
        visited[curR][curC] = true;
        count++;

        for (int dir = 0; dir < 4; dir++) {
            int nextR = curR + dx[dir];
            int nextC = curC + dy[dir];

            if (nextR < 0 || nextC < 0 || nextR >= m || nextC >= n) continue;
            else if (map[nextR][nextC] == 0 && !visited[nextR][nextC]) {
                dfs(nextR, nextC);
            }
        }

    }
}
