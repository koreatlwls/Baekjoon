package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P01932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int j = 0;
            do {
                arr[i][j++] = Integer.parseInt(st.nextToken());
            } while (st.hasMoreTokens());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = arr[i][j];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int upLeft, up;

                if (j == 0) upLeft = 0;
                else upLeft = dp[i - 1][j - 1];

                if (j == i) up = 0;
                else up = dp[i - 1][j];

                dp[i][j] = dp[i][j] + Math.max(upLeft, up);
            }
        }

        int result = 0;
        for(int i=0;i<n;i++){
            result = Math.max(dp[n-1][i],result);
        }
        System.out.print(result);
    }
}