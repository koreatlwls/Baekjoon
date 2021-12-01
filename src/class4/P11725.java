package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P11725 {

    static int n;
    static ArrayList<ArrayList<Integer>> list;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        parents = new int[n+1];

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        bfs();
        for(int i=2;i<=n;i++){
            System.out.println(parents[i]);
        }
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        parents[1] = 1;
        boolean[] visited = new boolean[n+ 1];
        visited[1] = true;

        while (!queue.isEmpty()) {
            int a = queue.poll();

            for(int check : list.get(a)){
                if(!visited[check]){
                    visited[check] = true;
                    parents[check] = a;
                    queue.offer(check);
                }
            }
        }
    }
}
