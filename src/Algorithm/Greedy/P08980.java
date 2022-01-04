package Algorithm.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P08980 {

    static int n,c,m;
    static ArrayList<Delivery> list = new ArrayList<>();

    static class Delivery implements  Comparable<Delivery>{
        int start;
        int end;
        int weight;

        public Delivery(int start,int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Delivery o) {
            if(this.end == o.end){
                return this.start - o.start;
            }
            return this.end - o.end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            list.add(new Delivery(x,y,z));
        }
        Collections.sort(list);

        int[] weight = new int[n+1];
        for(int i=1;i<n;i++){
            weight[i] = c;
        }

        int ans = 0;
        for(int i=0;i<m;i++){
            Delivery now = list.get(i);

            int maxBox = Integer.MAX_VALUE;
            for(int j=now.start;j<now.end;j++){
                maxBox = Math.min(maxBox, weight[j]);
            }

            if(maxBox >=now.weight){
                for(int j = now.start;j<now.end;j++){
                    weight[j] -= now.weight;
                }
                ans+=now.weight;
            }else{
                for(int j=now.start;j<now.end;j++){
                    weight[j] -= maxBox;
                }
                ans+=maxBox;
            }
        }

        System.out.print(ans);
    }
}
