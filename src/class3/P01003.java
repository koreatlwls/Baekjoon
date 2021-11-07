package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01003 {

    static Integer[][] dp = new Integer[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int input = Integer.parseInt(br.readLine());
            fibonacci(input);
            sb.append(dp[input][0]).append(" ").append(dp[input][1]).append("\n");
        }
        System.out.print(sb);
    }

    static Integer[] fibonacci(int N){
        if(dp[N][0] != null && dp[N][1] !=null){
            dp[N][0] = fibonacci(N-1)[0] + fibonacci(N-2)[0];
            dp[N][0] = fibonacci(N-1)[1] + fibonacci(N-2)[1];
        }
        return dp[N];
    }
}