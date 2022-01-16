package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01344 {

    static Double teamA, teamB;
    static boolean[] prime = new boolean[19];
    static double[][][] dp = new double[20][20][20];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        teamA = Double.parseDouble(br.readLine());
        teamA /= 100;
        teamB = Double.parseDouble(br.readLine());
        teamB /= 100;

        prime[0] = prime[1] = true;
        for(int i=2;i*i<=18;i++){
            if(!prime[i]){
                for(int j=i*i;j<=18;j+=i){
                    prime[j] = true;
                }
            }
        }

        dp[0][0][0] = 1.0;
        for(int i=1;i<=18;i++){
            for(int j=0;j<=i;j++){
                for(int k=0;k<=i;k++){
                    if(j>0)dp[i][j][k] += dp[i-1][j-1][k] *teamA * (1-teamB);
                    if(k>0)dp[i][j][k] += dp[i-1][j][k-1] * (1-teamA) * teamB;
                    if(j>0 && k>0) dp[i][j][k] += dp[i-1][j-1][k-1] * teamA * teamB;
                    dp[i][j][k] += dp[i-1][j][k] * (1-teamA) * (1-teamB);
                }
            }
        }

        double ans = 0;
        for(int i=0;i<=18;i++){
            for(int j=0;j<=18;j++){
                if(!prime[i] || !prime[j]) ans += dp[18][i][j];
            }
        }

        System.out.printf("%.9f", ans);
    }
}
