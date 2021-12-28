package Algorithm.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P09466 {

    static int n;
    static int[] link;
    static boolean[] visited, isSearchEnd;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            n = Integer.parseInt(br.readLine());

            link = new int[n+1];
            visited = new boolean[n+1];
            isSearchEnd = new boolean[n+1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1;i<=n;i++){
                link[i] = Integer.parseInt(st.nextToken());
            }

            cnt = 0;
            for(int i=1;i<=n;i++){
                dfs(i);
            }
            sb.append(n-cnt).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int pos){
        visited[pos] = true;
        int next = link[pos];
        if(!visited[next]){
            dfs(next);
        }else{
            if(!isSearchEnd[next]){
                cnt++;
                while(next != pos){
                    cnt++;
                    next = link[next];
                }
            }
        }
        isSearchEnd[pos] = true;
    }
}
