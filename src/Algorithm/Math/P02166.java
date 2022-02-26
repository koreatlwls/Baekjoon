package Algorithm.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P02166 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        long[] x = new long[N+1];
        long[] y = new long[N+1];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Long.parseLong(st.nextToken());
            y[i] = Long.parseLong(st.nextToken());
        }

        x[N] = x[0];
        y[N] = y[0];

        long sum_x = 0;
        long sum_y = 0;
        for(int i=0;i<N;i++){
            sum_x += x[i] * y[i+1];
            sum_y += x[i+1] * y[i];
        }

        String area = String.format("%.1f",(Math.abs(sum_x - sum_y) / 2.0));
        System.out.print(area);
    }
}
