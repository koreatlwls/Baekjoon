package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10026 {
    static char[][] grid;
    static int[][] pictures, patient;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int n;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.valueOf(st.nextToken());
        pictures = new int[n][n];
        patient = new int[n][n];
        grid = new char[n][];

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            grid[i] = str.toCharArray();
        }

        int count = 0, patientCount = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(pictures[i][j] == 0) {
                    count++;
                    dfs(i, j, grid[i][j], count);
                }

                if(patient[i][j] == 0) {
                    patientCount++;
                    patientDFS(i, j, grid[i][j], patientCount);
                }
            }
        }

        System.out.println(count + " " + patientCount);
    }

    static void patientDFS(int y, int x, char color, int count) {
        patient[y][x] = count;

        for(int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) {
                continue;
            }

            if(patient[nextY][nextX] != 0) {
                continue;
            }

            char nextColor = grid[nextY][nextX];
            if(nextColor == color) {
                patientDFS(nextY, nextX, nextColor, count);
            }
            else {
                if((color == 'R' && nextColor == 'G') || (color == 'G' && nextColor == 'R')) {
                    patientDFS(nextY, nextX, nextColor, count);
                }
            }
        }
    }

    static void dfs(int y, int x, char color, int count) {
        pictures[y][x] = count;

        for(int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) {
                continue;
            }

            if(pictures[nextY][nextX] != 0) {
                continue;
            }

            char nextColor = grid[nextY][nextX];
            if(nextColor == color) {
                dfs(nextY, nextX, nextColor, count);
            }
        }
    }
}
