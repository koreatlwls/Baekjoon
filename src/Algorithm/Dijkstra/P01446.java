package Algorithm.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P01446 {

    static int n,d;
    static ArrayList<Road> list;

    static class Road{
        int start;
        int end;
        int dist;

        public Road(int start,int end, int dist){
            this.start = start;
            this.end = end;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(b>d)continue;
            if(b-a<=c)continue;

            list.add(new Road(a,b,c));
        }

        Collections.sort(list, new Comparator<Road>() {
            @Override
            public int compare(Road o1, Road o2) {
                if(o1.start == o2.start)return o1.end - o2.end;
                return o1.start - o2.start;
            }
        });

        int idx = 0;
        int move = 0;
        int[] dist = new int[10001];
        Arrays.fill(dist,10001);
        dist[0]=0;

        while(move < d){
            if(idx < list.size()){
                Road now = list.get(idx);
                if(move == now.start){
                    dist[now.end] = Math.min(dist[move]+now.dist,dist[now.end]);
                    idx++;
                }else{
                    dist[move+1] = Math.min(dist[move+1], dist[move]+1);
                    move++;
                }
            }else{
                dist[move+1] = Math.min(dist[move+1], dist[move]+1);
                move++;
            }
        }

        System.out.print(dist[d]);
    }
}
