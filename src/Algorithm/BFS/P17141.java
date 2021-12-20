package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P17141 {

    static int n, m;
    static int map[][];
    static int min = Integer.MAX_VALUE;
    static ArrayList<Virus> virus = new ArrayList<>();
    static boolean visited[][];
    static int copy_map[][];
    static boolean virus_visited[];
    static int virus_arr[];
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};
    static int max = -1;

    static class Virus {
        int x;
        int y;
        int time;

        public Virus(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        copy_map = new int[n][n];
        map = new int[n][n];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    virus.add(new Virus(i, j, 0));
                }
            }
        }

        virus_visited = new boolean[virus.size()];
        virus_arr = new int[m];

        dfs(0, 0);

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    static void dfs(int at, int depth) {
        if (depth == m) {
            bfs();
            return;
        }

        for (int i = at; i < virus.size(); i++) {
            if (!virus_visited[i]) {
                virus_arr[depth] = i;
                virus_visited[i] = true;
                dfs(i + 1, depth + 1);
                virus_visited[i] = false;
            }
        }
    }

    public static void copy() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 2) {
                    copy_map[i][j] = 0;
                } else {
                    copy_map[i][j] = map[i][j];
                }
            }
        }
    }

    public static boolean isPossible() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (copy_map[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void bfs() {
        max = -1;
        copy();
        visited = new boolean[n][n];
        Queue<Virus> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            q.add(virus.get(virus_arr[i]));
            int x = virus.get(virus_arr[i]).x;
            int y = virus.get(virus_arr[i]).y;
            copy_map[x][y] = 2;
        }

        while (!q.isEmpty()) {
            Virus now = q.poll();
            max = Math.max(max, now.time);

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (!visited[nx][ny] && copy_map[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        copy_map[nx][ny] = 2;
                        q.add(new Virus(nx, ny, now.time + 1));
                    }
                }
            }
        }

        if (isPossible()) {
            min = Math.min(min, max);
        }
    }
}

