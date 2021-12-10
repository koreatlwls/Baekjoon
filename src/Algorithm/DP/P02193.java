package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P02193 {

    static Long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        dp = new Long[N+1][2];
        dp[1][0] = 0L;
        dp[1][1] = 1L;

        long result = 0;
        for(int i=0;i<2;i++){
            result += DP(N,i);
        }
        System.out.print(result);
    }

    static Long DP(int digit, int val){

        if(dp[digit][val] == null){
            if(val == 0){
                dp[digit][val] = DP(digit-1,0) + DP(digit-1,1);
            }else{
                dp[digit][val] = DP(digit-1,0);
            }
        }

        return dp[digit][val];
    }
}
