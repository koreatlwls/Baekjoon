package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P14442 {

    static int n, m, k;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][][] visited;

    static class Node {
        int row;
        int col;
        int cnt;
        int wall;

        public Node(int row, int col, int cnt, int wall) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
            this.wall = wall;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m][k+1];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        System.out.print(bfs());
    }

    static int bfs(){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0,0,1,0));
        visited[0][0][0] = true;

        while(!queue.isEmpty()){
            Node now = queue.poll();

            if(now.row == n-1 && now.col == m-1){
                return now.cnt;
            }

            for(int i=0;i<4;i++){
                int nextRow = now.row + dr[i];
                int nextCol = now.col + dc[i];

                if(nextRow>=0 && nextCol >=0 && nextRow <n && nextCol <m){
                    if(map[nextRow][nextCol] ==0 && !visited[nextRow][nextCol][now.wall]){
                        queue.offer(new Node(nextRow,nextCol, now.cnt+1,now.wall));
                        visited[nextRow][nextCol][now.wall] = true;
                    }else if(map[nextRow][nextCol] == 1 && now.wall<k&& !visited[nextRow][nextCol][now.wall]){
                        queue.offer(new Node(nextRow,nextCol,now.cnt+1,now.wall+1));
                        visited[nextRow][nextCol][now.wall] = true;
                    }
                }
            }
        }

        return -1;
    }
}
