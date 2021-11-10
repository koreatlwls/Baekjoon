package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P02606 {

    static LinkedList<Integer>[] adjList;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        adjList = new LinkedList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            adjList[i] = new LinkedList<Integer>();
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adjList[x].add(y);
            adjList[y].add(x);
        }

        dfs(1);
        System.out.print(count);
    }

    static void dfs(int v){
        visited[v]=true;
        for(int value:adjList[v]){
            if(!visited[value]){
                count++;
                dfs(value);
            }
        }
    }
}
