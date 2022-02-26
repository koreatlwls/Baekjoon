package Algorithm.BFS;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P11967 {

    static int N, M;
    static ArrayList<Point>[][] list;
    static boolean[][] visited;
    static boolean[][] lightOn;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1][N + 1];
        lightOn = new boolean[N + 1][N + 1];
        list = new ArrayList[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                list[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            list[a][b].add(new Point(c, d));
        }

        System.out.print(bfs()+1);
    }

    static int bfs() {
        initArrays();
        int cnt = 0;
        boolean flag = false;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(1, 1));
        visited[1][1] = true;
        lightOn[1][1] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (Point check : list[now.x][now.y]) {
                if (!lightOn[check.x][check.y]) {
                    lightOn[check.x][check.y] = true;
                    cnt++;
                    flag = true;
                }
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = now.x + dr[i];
                int nextCol = now.y + dc[i];

                if (nextRow < 1 || nextCol < 1 || nextRow > N || nextCol > N) continue;
                if (visited[nextRow][nextCol] || !lightOn[nextRow][nextCol]) continue;

                visited[nextRow][nextCol] = true;
                queue.add(new Point(nextRow, nextCol));
            }
        }

        if(flag){
            cnt+= bfs();
        }

        return cnt;
    }

    static void initArrays(){
        for(int i=1;i<=N;i++){
            Arrays.fill(visited[i],false);
        }
    }
}
