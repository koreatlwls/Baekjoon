package Algorithm.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P13305 {

    static int n;
    static long[] dist;
    static long[] oil;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        dist = new long[n - 1];
        oil = new long[n];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < n - 1; i++) {
            dist[i] = Long.parseLong(st1.nextToken());
        }

        for (int i = 0; i < n; i++) {
            oil[i] = Long.parseLong(st2.nextToken());
        }

        long min = oil[0];
        long cost = 0;
        for(int i=0;i<n-1;i++){
            min = Math.min(min,oil[i]);
            cost += dist[i] * min;
        }

        System.out.print(cost);
    }
}
