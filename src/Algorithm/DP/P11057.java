package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11057{

    static int[][] dp;
    static final int MOD = 10007;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        dp = new int[1001][10];
        int n = Integer.parseInt(br.readLine());

        int result = 0;
        for(int i=0; i <= 9; i++){
            result += topDown(n, i);
            result %= MOD;
        }
        System.out.print(result);
    }

    public static int topDown(int n, int i){
        if(n == 1) return dp[n][i] = 1;
        if(dp[n][i] > 0) return dp[n][i];

        for(int k=0; k <= i; k++){
            dp[n][i] += topDown(n-1, k);
            dp[n][i] %= MOD;
        }

        return dp[n][i];
    }
}
