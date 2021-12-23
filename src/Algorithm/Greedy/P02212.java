package Algorithm.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P02212 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        if (k >= n) {
            System.out.print(0);
            return;
        }

        int[] censor = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            censor[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(censor);

        int[] dif = new int[n - 1];

        for (int i = 0; i < n - 1; i++) {
            dif[i] = censor[i + 1] - censor[i];
        }

        Arrays.sort(dif);

        int ans = 0;
        for (int i = 0; i < n - k; i++) {
            ans += dif[i];
        }

        System.out.print(ans);
    }

}