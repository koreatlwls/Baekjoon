package Algorithm.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P06603 {

    static int k;
    static int[] input;
    static boolean[] visited;
    static final int lotto = 6;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            if (k == 0) {
                break;
            }

            input = new int[k];
            visited = new boolean[k];
            arr = new int[lotto];

            for (int i = 0; i < k; i++) {
                input[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int at, int depth){
        if(depth == lotto){
            for(int val : arr){
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=at;i<k;i++){
            if(!visited[i]){
                visited[i] =true;
                arr[depth] = input[i];
                dfs(i+1, depth+1);
                visited[i] = false;
            }
        }
    }
}
