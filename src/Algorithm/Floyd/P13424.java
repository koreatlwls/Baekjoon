package Algorithm.Floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P13424 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] dist = new int[N+1][N+1];
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    if(i==j)dist[i][j] = 0;
                    else dist[i][j] = 1000000;
                }
            }

            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                dist[s][e] = c;
                dist[e][s] = c;
            }

            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    for(int k=1;k<=N;k++){
                        dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
                    }
                }
            }

            int person = Integer.parseInt(br.readLine());
            int[] personInfo = new int[person];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<person;i++){
                personInfo[i] = Integer.parseInt(st.nextToken());
            }

            int ansLen = 1000000;
            int ans = -1;
            for(int i=1;i<=N;i++){
                int tempLen = 0;
                for(int j=0;j<person;j++){
                    tempLen+=dist[personInfo[j]][i];
                }
                if(tempLen < ansLen){
                    ansLen =tempLen;
                    ans = i;
                }
            }

            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }
}
