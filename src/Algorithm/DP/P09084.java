package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P09084 {

    static int n,m;
    static int[] coin;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            n = Integer.parseInt(br.readLine());

            coin = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                coin[i] = Integer.parseInt(st.nextToken());
            }

            m = Integer.parseInt(br.readLine());
            dp = new int[m+1];
            dp[0] = 1;

            for(int i=0;i<n;i++){
                for(int j=coin[i];j<=m;j++){
                    dp[j] += dp[j-coin[i]];
                }
            }

            sb.append(dp[m]).append("\n");
        }

        System.out.print(sb);
    }
}
