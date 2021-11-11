package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());
        int count = 0;
        Integer[] coin = new Integer[N];
        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coin,Collections.reverseOrder());

        while (K > 0) {
            for (int i = 0; i < N; i++) {
                if (K >= coin[i]) {
                    K -= coin[i];
                    count++;
                    break;
                }
            }
        }

        System.out.print(count);
    }
}
