package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P02096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] maxDp = new int[3];
        int[] minDp = new int[3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (i == 0) {
                maxDp[0] = minDp[0] = a;
                maxDp[1] = minDp[1] = b;
                maxDp[2] = minDp[2] = c;
            } else {
                int max_0 = maxDp[0];
                int max_1 = maxDp[1];
                int max_2 = maxDp[2];

                maxDp[0] = Math.max(max_0, max_1) + a;
                maxDp[1] = Math.max(Math.max(max_0, max_1), max_2) + b;
                maxDp[2] = Math.max(max_1, max_2) + c;

                int min_0 = minDp[0];
                int min_1 = minDp[1];
                int min_2 = minDp[2];

                minDp[0] = Math.min(min_0, min_1) + a;
                minDp[1] = Math.min(Math.min(min_0, min_1), min_2) + b;
                minDp[2] = Math.min(min_1, min_2) + c;
            }
        }

        int max = Math.max(Math.max(maxDp[0], maxDp[1]), maxDp[2]);
        int min = Math.min(Math.min(minDp[0], minDp[1]), minDp[2]);
        System.out.print(max + " " + min);
    }
}
