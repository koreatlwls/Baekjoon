package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P02643 {

    static int n;
    static ArrayList<Paper> papers = new ArrayList<>();

    static class Paper implements Comparable<Paper>{
        int x;
        int y;

        public Paper(int x,int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Paper o){
            if(this.x == o.x){
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a<b) {
                papers.add(new Paper(a, b));
            }else{
                papers.add(new Paper(b,a));
            }
        }

        Collections.sort(papers);

        int res = 0;
        int[] dp = new int[n];

        for(int i=0;i<n;i++){
            Paper now = papers.get(i);
            dp[i] = 1;
            for(int j=0;j<i;j++){
                Paper next = papers.get(j);
                if(now.x>=next.x && now.y>=next.y){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            res = Math.max(res,dp[i]);
        }

        System.out.print(res);
    }
}
