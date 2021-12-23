package Algorithm.BinSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P01939 {

    static int n, m;
    static boolean[] visited;
    static ArrayList<ArrayList<Island>> list;
    static int start, end;

    static class Island {
        int end;
        int weight;

        public Island(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        int max = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(a).add(new Island(b, c));
            list.get(b).add(new Island(a, c));

            max = Math.max(max, c);
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int left = 0;
        int right = max;

        while(left <= right){
            int mid = (left+right)/2;
            visited = new boolean[n+1];

            if(bfs(mid)){
                left = mid +1;
            }else{
                right = mid -1;
            }
        }

        System.out.print(right);
    }

    static boolean bfs(int weight) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();

            if(now == end){
                return true;
            }

            for(Island i : list.get(now)){
                if(!visited[i.end] && weight <= i.weight){
                    visited[i.end] = true;
                    queue.offer(i.end);
                }
            }
        }

        return false;
    }
}
