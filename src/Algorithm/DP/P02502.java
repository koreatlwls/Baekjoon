package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P02502 {

    static int D, K;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[D+1][2];
        dp[1][0] = 1;
        dp[1][1] = 0;
        dp[2][0] = 0;
        dp[2][1] = 1;

        for(int i=3;i<=D;i++){
            dp[i][0] = dp[i-2][0] + dp[i-1][0];
            dp[i][1] = dp[i-2][1] + dp[i-1][1];
        }

        int A = 1;
        int B = 1;

        int aCnt = dp[D][0];
        int bCnt = dp[D][1];

        while(true){
            int num = A * aCnt + B * bCnt;

            if(num == K){
                break;
            }else if(num > K){
                A++;
                B = A;
            }else{
                B++;
            }
        }

        System.out.println(A);
        System.out.print(B);
    }
}
