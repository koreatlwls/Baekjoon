package Algorithm.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P20168 {

    static class road{
        int from;
        int to;
        int cost;

        road(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static int N, M, A, B, C;
    static ArrayList<road> adj[];
    static boolean[] isVisited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N+1];
        for(int i = 0 ; i < N+1; i++){
            adj[i] = new ArrayList<>();
        }

        isVisited = new boolean[N+1];
        answer = Integer.MAX_VALUE;

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj[a].add(new road(a, b, c));
            adj[b].add(new road(b, a, c));
        }

        isVisited[A] = true;
        DFS(A, C, -1);

        answer = answer == Integer.MAX_VALUE ? -1 : answer;

        System.out.println(answer);

    }

    private static void DFS(int nowNode, int haveMoney, int maxCost) {
        if(nowNode == B){
            answer = Math.min(answer, maxCost);
            return;
        }

        if(haveMoney <= 0)
            return;

        for(road nextNode : adj[nowNode]){
            if(!isVisited[nextNode.to] && nextNode.cost <= haveMoney){
                isVisited[nextNode.to] = true;
                DFS(nextNode.to, haveMoney - nextNode.cost, Math.max(nextNode.cost, maxCost));
                isVisited[nextNode.to] = false;
            }
        }
    }
}