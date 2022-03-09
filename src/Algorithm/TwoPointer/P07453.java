package Algorithm.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P07453 {

    static int N;
    static long ans;
    static int[] A, B, C, D;
    static int[] AB, CD;
    static int ABidx, CDidx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        A = new int[N];
        B = new int[N];
        C = new int[N];
        D = new int[N];

        AB = new int[N * N];
        CD = new int[N * N];

        ans = 0;

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        ABidx = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                AB[ABidx] = A[i] + B[j];
                CD[ABidx] = C[i] + D[j];
                ABidx++;
            }
        }
        CDidx = ABidx -1;

        Arrays.sort(AB);
        Arrays.sort(CD);

        for(int i=0;i<ABidx&& CDidx>=0;){
            int ABsum = AB[i];
            int CDsum = CD[CDidx];
            int ABcnt = 0;
            int CDcnt = 0;
            int totSum = ABsum + CDsum;

            if(totSum == 0){
                while(i<ABidx && ABsum == AB[i]){
                    i++;
                    ABcnt++;
                }

                while(CDidx>=0 && CDsum == CD[CDidx]){
                    CDidx--;
                    CDcnt++;
                }

                ans+=(long)ABcnt * (long)CDcnt;
            }else if(totSum>0){
                CDidx--;
            }else{
                i++;
            }
        }

        System.out.print(ans);
    }
}
