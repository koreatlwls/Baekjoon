package Algorithm.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P03980 {

    static int[][] player;
    static int max;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            player = new int[11][11];
            visited = new boolean[11];
            max = Integer.MIN_VALUE;

            for (int i = 0; i < 11; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 11; j++) {
                    player[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dfs(0, 0);
            sb.append(max).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int depth, int score) {
        if(depth == 11){
            max = Math.max(max, score);
            return;
        }

        for(int i=0;i<11;i++){
            if(!visited[i] && player[i][depth] >0){
                visited[i] = true;
                dfs(depth+1, score + player[i][depth]);
                visited[i] = false;
            }
        }
    }
}
