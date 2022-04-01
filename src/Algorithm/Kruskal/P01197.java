package Algorithm.Kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P01197 {

    static int V, E;
    static int[][] graph;
    static int[] parent;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new int[E][3];
        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
            graph[i][2] = Integer.parseInt(st.nextToken());
        }

        parent = new int[V+1];
        for(int i=0;i<=V;i++){
            parent[i] = i;
        }

        result = 0;

        Arrays.sort(graph, (o1, o2) -> Integer.compare(o1[2], o2[2]));

        for(int i=0;i<E;i++){
            if(find(graph[i][0]) != find(graph[i][1])){
                union(graph[i][0], graph[i][1]);
                result += graph[i][2];
            }
        }

        System.out.print(result);
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x > y){
            parent[x] = y;
        }else{
            parent[y] = x;
        }
    }

    static int find(int x){
        if(x == parent[x]){
            return x;
        }

        return find(parent[x]);
    }
}
