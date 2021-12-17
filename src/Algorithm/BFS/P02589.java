package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P02589 {

    static int n, m;
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int result = Integer.MIN_VALUE;

    static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j] == 'W')continue;
                result = Math.max(result, bfs(i,j)-1);
            }
        }

        System.out.print(result);
    }

    static int bfs(int row, int col) {
        int count = 0;
        visited = new boolean[n][m];
        Queue<Point> queue = new LinkedList<>();

        queue.offer(new Point(row, col));
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point now = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int nextRow = now.row + dr[j];
                    int nextCol = now.col + dc[j];

                    if (nextRow < 0 || nextCol < 0 || nextRow >= n || nextCol >= m) continue;
                    if (map[nextRow][nextCol] == 'W' || visited[nextRow][nextCol]) continue;

                    visited[nextRow][nextCol] = true;
                    queue.offer(new Point(nextRow, nextCol));
                }
            }

            count++;
        }

        return count;
    }
}
