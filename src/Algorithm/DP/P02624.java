package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P02624 {

    static int[][] coin;
    static int[][] dp;
    static int T,k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        coin = new int[k][2];
        dp = new int[k][T+1];

        for(int i=0;i<k;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            coin[i][0] = Integer.parseInt(st.nextToken());
            coin[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<k;i++){
            for(int j=0;j<T;j++){
                dp[i][j] = -1;
            }
        }

        System.out.print(comb(0,0));
    }

    static int comb(int money, int coinType) {
        if(money == T) {
            return 1;
        }
        if(coinType ==k || money>T) {
            return 0;
        }
        if(dp[coinType][money] !=-1) {
            return dp[coinType][money];
        }

        int res = 0;
        for(int i=0; i<coin[coinType][1]+1; i++) {
            int cost = coin[coinType][0]*i;
            res += comb(money + cost , coinType+1 );
        }
        return dp[coinType][money] = res;
    }
}
