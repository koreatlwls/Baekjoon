package Algorithm.UnionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10216 {

    static int[] parent;
    static int[][] unit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            int N = Integer.parseInt(br.readLine());

            parent = new int[N];
            unit = new int[N][3];

            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                unit[i][0] = x;
                unit[i][1] = y;
                unit[i][2] = r;

                parent[i] = i;
            }

            int ans = N;
            for(int i=0;i<N;i++){
                for(int j=i+1;j<N;j++){
                    int xDif = unit[i][0] - unit[j][0];
                    int yDif = unit[i][1] - unit[j][1];
                    int r = unit[i][2] + unit[j][2];

                    if(xDif * xDif + yDif * yDif <= r * r){
                        if(find(i) != find(j)){
                            union(i,j);
                            ans--;
                        }
                    }
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }

    static int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (x < y) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }
        }
    }
}
