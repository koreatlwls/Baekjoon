package Algorithm.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14889 {

    static int n;
    static int[][] input;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        input = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.print(min);
    }

    static void dfs(int at, int depth) {
        if (depth == n / 2) {
            diff();
            return;
        }

        for (int i = at; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    static void diff() {
        int team_start = 0;
        int team_link = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visited[i] && visited[j]) {
                    team_start += input[i][j];
                    team_start += input[j][i];
                } else if (!visited[i] && !visited[j]) {
                    team_link += input[i][j];
                    team_link += input[j][i];
                }
            }
        }

        int val = Math.abs(team_start - team_link);

        if (val == 0) {
            System.out.print(val);
            System.exit(0);
        }

        min = Math.min(val, min);
    }
}
