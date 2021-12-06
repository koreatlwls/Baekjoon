package Algorithm.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P04963 {

    static int w, h;
    static int[][] map;
    static int[][] check;
    static int[] dr = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dc = {0, 0, -1, 1, 1, 1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            map = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            check = new int[h][w];
            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && check[i][j] == 0) {
                        dfs(i, j, ++count);
                    }
                }
            }
            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int row, int col, int count) {
        if(map[row][col] ==1){
            check[row][col] = count;
        }else {
            return;
        }

        for (int i = 0; i < 8; i++) {
            int nextRow = row + dr[i];
            int nextCol = col + dc[i];

            if (nextRow < 0 || nextCol < 0 || nextRow >= h || nextCol >= w) {
                continue;
            }

            if(check[nextRow][nextCol]>0){
                continue;
            }

            dfs(nextRow, nextCol, count);
        }
    }
}
