package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P01937 {

    static int n;
    static int[][] map;
    static int[][] dp;

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        dp = new int[n][n];

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                ans = Math.max(ans, DFS(i,j));
            }
        }

        System.out.print(ans);
    }

    static int DFS(int row, int col){
        if(dp[row][col] != 0){
            return dp[row][col];
        }

        dp[row][col] = 1;

        for(int i=0;i<4;i++){
            int nextRow = row + dr[i];
            int nextCol = col + dc[i];

            if(nextRow < 0 || nextCol <0 || nextRow >=n || nextCol >= n){
                continue;
            }

            if(map[row][col] < map[nextRow][nextCol]){
                dp[row][col] = Math.max(dp[row][col], DFS(nextRow, nextCol)+1);
                DFS(nextRow,nextCol);
            }
        }
        return dp[row][col];
    }
}
