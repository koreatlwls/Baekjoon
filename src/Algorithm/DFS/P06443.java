package Algorithm.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P06443 {

    static int N;
    static char[] arr, result, mx;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            arr = br.readLine().toCharArray();
            int len = arr.length;
            result = new char[len];
            mx = new char[len];
            visited = new boolean[len];

            Arrays.sort(arr);

            dfs(len, 0);
        }
        System.out.print(sb);
    }

    static void dfs(int len, int depth){
        if(len == depth){
            sb.append(result).append("\n");
            return;
        }

        mx[depth] = 0;
        for(int i=0;i<len;i++){
            if(visited[i])continue;
            if(mx[depth] >= arr[i]) continue;

            mx[depth] = arr[i];
            visited[i] = true;
            result[depth] = arr[i];
            dfs(len, depth+1);
            visited[i] = false;
        }
    }
}
