package Algorithm.BinSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P03079 {

    static int N, M;
    static int[] time;
    static long MAX = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        time = new int[N];
        for (int i = 0; i < N; i++) {
            time[i] = Integer.parseInt(br.readLine());
            MAX = Math.max(MAX, time[i]);
        }

        getMinTime();
    }

    static void getMinTime() {
        long start = 0;
        long end = MAX * M;

        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;

            for(int ele : time){
                long needPeopleCnt = mid/ele;
                sum+=needPeopleCnt;
            }

            if(sum>=M) end = mid-1;
            else start = mid+1;
        }
        System.out.print(start);
    }
}
