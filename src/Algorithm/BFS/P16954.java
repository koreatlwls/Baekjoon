package Algorithm.BFS;

import java.io.*;
import java.util.*;

public class P16954 {

    static char[][] map = new char[8][8];
    static Queue<Position> queue = new LinkedList<>();
    static int ans;
    static int[] dr = {0, 1, 0, -1, 0, 1, -1, -1, 1};
    static int[] dc = {0, 0, 1, 0, -1, 1, 1, -1, -1};

    static class Position {
        int row;
        int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<8;i++){
            char[] ch = br.readLine().toCharArray();
            for(int j=0;j<8;j++){
                map[i][j] = ch[j];
            }
        }

        queue.add(new Position(7,0));

        ans = (bfs())? 1:0;
        System.out.print(ans);
    }

    static boolean bfs(){
        while(!queue.isEmpty()){
            int size = queue.size();

            for(int t=0;t<size;t++){
                Position now = queue.poll();

                if(map[now.row][now.col] == '#')continue;

                for(int i=0;i<9;i++){
                    int nextRow = now.row + dr[i];
                    int nextCol = now.col + dc[i];

                    if(nextRow<0 || nextRow>=8 || nextCol <0 || nextCol>=8)continue;

                    if(nextRow ==0 && nextCol ==7)return true;

                    if(map[nextRow][nextCol] != '#'){
                        queue.add(new Position(nextRow,nextCol));
                    }
                }
            }
            down();
        }

        return false;
    }

    static void down(){
        for(int i=7;i>=0;i--){
            for(int j=7;j>=0;j--){
                if(i-1<0)map[i][j] ='.';
                else map[i][j] = map[i-1][j];
            }
        }
    }
}
