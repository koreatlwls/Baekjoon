package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P01325 {

    static int N,M;
    static List<Integer>[] list;
    static int[] visited = new int[10001];
    static int[] ans = new int[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new int[N+1];
        ans = new int[N+1];

        list = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
        }

        for(int i=1;i<=N;i++){
            visited = new int[N+1];
            bfs(i);
        }

        int max = 0;
        for(int i=1;i<=N;i++){
            max = Math.max(max, ans[i]);
        }

        for(int i=1;i<=N;i++){
            if(max == ans[i]){
                sb.append(i + " ");
            }
        }

        System.out.print(sb);
    }

    static void bfs(int node){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = 1;

        while(!queue.isEmpty()){
            node = queue.remove();
            for(int next: list[node]){
                if(visited[next] == 0){
                    ans[next]++;
                    visited[next] = 1;
                    queue.add(next);
                }
            }
        }
    }
}
