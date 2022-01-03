package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P02146 {

    static int[][] map;
    static boolean[][] visited;
    static int n;
    static int result = Integer.MAX_VALUE;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    static class Position{
        int row;
        int col;
        int cnt;

        public Position(int row, int col, int cnt){
            this.row = row;
            this.col = col;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map[i][j] == 1){
                    visited = new boolean[n][n];
                    sameLand(i,j);
                    bfs(i,j);
                }
            }
        }

        if(result == Integer.MAX_VALUE){
            result = 0;
        }

        System.out.print(result);
    }

    static void bfs(int row, int col){
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(row,col,0));

        while(!queue.isEmpty()){
            Position now = queue.poll();

            for(int i=0;i<4;i++){
                int nextRow = now.row + dr[i];
                int nextCol = now.col + dc[i];

                if(nextRow >=0 && nextCol >=0 && nextRow <n && nextCol <n){
                  if(map[nextRow][nextCol] ==0 && !visited[nextRow][nextCol]){
                      visited[nextRow][nextCol] = true;
                      queue.add(new Position(nextRow,nextCol,now.cnt+1));
                  }else if(map[nextRow][nextCol]==1 && now.cnt>0&& !visited[nextRow][nextCol]){
                      result = Math.min(result, now.cnt);
                  }
                }
            }
        }
    }

    static void sameLand(int row, int col){
        visited[row][col] = true;

        for(int i=0;i<4;i++){
            int nextRow = row +dr[i];
            int nextCol = col + dc[i];

            if(nextRow >=0 && nextCol >=0 && nextRow <n && nextCol <n){
                if(map[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]){
                    sameLand(nextRow,nextCol);
                }
            }
        }
    }
}
