package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11054 {

    static int[] arr;
    static int[] dp;
    static int[] dp2;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        dp2 = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            LIS(i);
            LIS2(i);
        }

        int max = Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            max = Math.max(max, dp[i]+dp2[i]);
        }
        System.out.print(max-1);
    }

    static int LIS(int n) {
        if (dp[n] == 0) {
            dp[n] = 1;

            for (int i = n - 1; i >= 0; i--) {
                if (arr[i] < arr[n]) {
                    dp[n] = Math.max(dp[n], LIS(i) + 1);
                }
            }
        }

        return dp[n];
    }

    static int LIS2(int n) {
        if (dp2[n] == 0) {
            dp2[n] = 1;

            for (int i = n + 1; i < N; i++) {
                if (arr[i] < arr[n]) {
                    dp2[n] = Math.max(dp2[n], LIS2(i) + 1);
                }
            }
        }

        return dp2[n];
    }
}
