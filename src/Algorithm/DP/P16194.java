package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P16194 {

    static int N;
    static int[] card;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        card = new int[N+1];
        dp = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            card[i] = Integer.parseInt(st.nextToken());
            dp[i] = Integer.MAX_VALUE;
        }

        for(int i=1;i<=N;i++){
            for(int j=1;j<=i;j++){
                dp[i] = Math.min(dp[i], dp[i-j] + card[j]);
            }
        }

        System.out.print(dp[N]);
    }
}
