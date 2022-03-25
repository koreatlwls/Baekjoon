package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P12852 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+2];
        int[] trace = new int[N+2];

        dp[1] =0;
        trace[1] = -1;

        for(int i=2;i<=N;i++){
            dp[i] = dp[i-1] +1;
            trace[i] = i-1;

            if(i%2==0 && dp[i] > dp[i/2] +1){
                dp[i] = dp[i/2]+1;
                trace[i] = i/2;
            }
            if(i%3==0 && dp[i] > dp[i/3] +1){
                dp[i] = dp[i/3] +1;
                trace[i] = i/3;
            }
        }

        sb.append(dp[N]).append("\n");

        int index = N;
        for(int i=0;i<=dp[N];i++){
            sb.append(index+" ");
            index = trace[index];
        }
        System.out.print(sb);
    }
}
