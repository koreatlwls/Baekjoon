package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P02688 {

    static int n;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            n = Integer.parseInt(br.readLine());
            dp = new long[n+1][10];

            for(int i=0;i<10;i++){
                dp[1][i] = 1;
            }

            for(int i=2;i<=n;i++){
                for(int j=0;j<10;j++){
                    for(int k=0;k<=j;k++){
                        dp[i][j] += dp[i-1][k];
                    }
                }
            }

            long result = 0;
            for(int i=0;i<10;i++){
                result += dp[n][i];
            }

            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }
}
