package Algorithm.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P05972 {

    static int N, M;
    static ArrayList<ArrayList<Node>> list;

    static class Node {
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list.get(start).add(new Node(end, cost));
            list.get(end).add(new Node(start, cost));
        }

        System.out.print(solve());
    }

    static int solve(){
        int[] dist = new int[N+1];
        for(int i=0;i<N+1;i++){
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.cost - o2.cost;
        });

        pq.offer(new Node(1,0));
        dist[1] = 0;

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(dist[now.end] < now.cost){
                continue;
            }

            for(int i=0;i<list.get(now.end).size();i++){
                Node nextNode = list.get(now.end).get(i);

                if(dist[nextNode.end] > now.cost + nextNode.cost){
                    dist[nextNode.end] = now.cost + nextNode.cost;
                    pq.offer(new Node(nextNode.end, dist[nextNode.end]));
                }
            }
        }

        return dist[N];
    }
}
