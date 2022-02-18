package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P17244 {

    static int n, m, k;
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    static char[][] map = new char[51][51];
    static boolean[][][] visited = new boolean[51][51][(1 << 6)];

    static class Point {
        int row, col, cnt, item;

        public Point(int row, int col, int cnt, int item) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
            this.item = item;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        int sR = 0, sC = 0;
        char idx = '0';

        for (int i = 1; i <= n; i++) {
            String input = br.readLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = input.charAt(j-1);

                if (map[i][j] == 'X') {
                    map[i][j] = idx++;
                    k++;
                } else if (map[i][j] == 'S') {
                    sR = i;
                    sC = j;
                }
            }
        }

        System.out.print(bfs(sR, sC));
    }

    static int bfs(int row, int col) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(row, col, 0, 0));
        visited[row][col][0] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            if (map[now.row][now.col] == 'E' && now.item == ((1 << k) - 1)) {
                return now.cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = now.row + dr[i];
                int nextCol = now.col + dc[i];

                if (nextRow < 1 || nextCol < 1 || nextRow > n || nextCol > m || visited[nextRow][nextCol][now.item] || map[nextRow][nextCol] == '#')
                    continue;

                if (map[nextRow][nextCol] >= '0' && map[nextRow][nextCol] <= '5') {
                    int num = map[nextRow][nextCol] - '0';

                    if((now.item & (1<<num))== 0){
                        int nItem = now.item | (1<<num);
                        visited[nextRow][nextCol][nItem] = true;
                        queue.add(new Point(nextRow,nextCol,now.cnt+1,nItem));
                        continue;
                    }
                }

                visited[nextRow][nextCol][now.item] = true;
                queue.add(new Point(nextRow, nextCol, now.cnt+1, now.item));
            }
        }

        return 0;
    }
}
