package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P02300 {

    static int N;
    static Building[] buildings;
    static int[] dp = new int[10001];

    static class Building implements Comparable<Building> {
        int x;
        int y;

        public Building(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Building o) {
            if (this.x == o.x) {
                return Math.abs(this.y) - Math.abs(o.y);
            } else {
                return this.x - o.x;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        buildings = new Building[N];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            buildings[i] = new Building(x,y);
        }

        Arrays.sort(buildings);

        for(int i=1;i<=N;i++){
            int mH = 0;
            dp[i] = Integer.MAX_VALUE;
            for(int j=i;j>=1;j--){
                mH = Math.max(mH, Math.abs(buildings[j-1].y));
                dp[i] = Math.min(dp[i], dp[j-1] + Math.max( 2*mH, buildings[i-1].x - buildings[j-1].x));
            }
        }

        System.out.print(dp[N]);
    }
}
