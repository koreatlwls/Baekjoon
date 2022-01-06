package Algorithm.BellmanFord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P11657 {

    static int n, m;
    static ArrayList<ArrayList<City>> cityList;
    static long[] dist;
    static final int INF = 987654321;

    static class City {
        int end;
        int time;

        public City(int end, int time) {
            this.end = end;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        cityList = new ArrayList<>();
        dist = new long[n+1];

        for (int i = 0; i <= n; i++) {
            cityList.add(new ArrayList<>());
            dist[i] = INF;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            cityList.get(a).add(new City(b, c));
        }

        if(bellmanFord()){
            sb.append("-1\n");
        }else{
            for(int i=2;i<=n;i++){
                if(dist[i] == INF){
                    sb.append("-1\n");
                }else{
                    sb.append(dist[i]).append("\n");
                }
            }
        }

        System.out.print(sb);
    }

    static boolean bellmanFord(){
        dist[1] = 0;
        boolean update = false;

        for(int i=1;i<n;i++){
            update = false;

            for(int j=1;j<=n;j++){
                for(City city: cityList.get(j)){
                    if(dist[j] == INF){
                        break;
                    }

                    if(dist[city.end] > dist[j] + city.time){
                        dist[city.end] = dist[j] + city.time;
                        update = true;
                    }
                }
            }
        }

        if(update){
           for(int i=1;i<=n;i++){
               for(City city: cityList.get(i)){
                   if(dist[i] == INF){
                       break;
                   }

                   if(dist[city.end] > dist[i] + city.time){
                       return true;
                   }
               }
           }
        }

        return false;
    }
}
