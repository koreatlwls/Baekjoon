package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P17626 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int dp[] = new int[N + 1];

        dp[0] = 0;
        dp[1] = 1;
        if (N >= 2) {
            for (int i = 2; i <= N; i++) {
                int sqrt = (int) Math.sqrt(i);
                int min = Integer.MAX_VALUE;
                for (int j = 1; j <= sqrt; j++) {
                    min = Math.min(min, 1 + dp[i - (int) Math.pow(j, 2)]);
                }
                dp[i] = min;
            }
        }
        System.out.print(dp[N]);
    }
}
