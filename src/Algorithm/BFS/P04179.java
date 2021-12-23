package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P04179 {

    static int r, c;
    static char[][] maze;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Point jihun;

    static class Point {
        int row;
        int col;
        int type;
        int count;

        public Point(int row, int col, int type, int count) {
            this.row = row;
            this.col = col;
            this.type = type;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        maze = new char[r][c];
        visited = new boolean[r][c];
        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < r; i++) {
           String input = br.readLine();
            for (int j = 0; j < c; j++) {
                maze[i][j] = input.charAt(j);

                if (maze[i][j] == 'J') {
                    if (isEdge(i, j)) {
                        System.out.print(1);
                        return;
                    }

                    maze[i][j] = '.';
                    jihun = new Point(i,j,0,0);
                }else if(maze[i][j] == 'F'){
                    queue.offer(new Point(i,j,1,0));
                }
            }
        }

        bfs(queue);
    }

    static boolean isRange(int row, int col) {
        if (row >= 0 && col >= 0 && row < r && col < c) {
            return true;
        }

        return false;
    }

    static boolean isEdge(int row, int col) {
        for (int i = 0; i < 4; i++) {
            int nextRow = row + dr[i];
            int nextCol = col + dc[i];

            if (!isRange(nextRow, nextCol)) {
                return true;
            }
        }

        return false;
    }

    static void bfs(Queue<Point> queue){

        int row;
        int col;
        int count;

        queue.offer(jihun);
        visited[jihun.row][jihun.col] = true;

        while(!queue.isEmpty()){
            Point now = queue.poll();
            row = now.row;
            col = now.col;
            count = now.count;

            if(isEdge(row,col) && now.type==0){
                System.out.print(count+1);
                return ;
            }

            for(int i=0;i<4;i++){
                int nextRow = row + dr[i];
                int nextCol = col + dc[i];

                if(!isRange(nextRow, nextCol) || maze[nextRow][nextCol] == '#' || maze[nextRow][nextCol] == 'F'){
                    continue;
                }

                if(now.type==0 && !visited[nextRow][nextCol]){
                    queue.offer(new Point(nextRow, nextCol, now.type, count+1));
                    visited[nextRow][nextCol]  = true;
                }else if(now.type == 1){
                    maze[nextRow][nextCol] = 'F';
                    queue.offer(new Point(nextRow,nextCol,now.type, count+1));
                }
            }
        }

        System.out.print("IMPOSSIBLE");
    }
}
