package Algorithm.BinSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P02473 {

    static int n;
    static long[] inputs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        inputs = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inputs[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(inputs);

        long[] res = new long[3];
        long diff = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                long sum = inputs[i] + inputs[left] + inputs[right];
                long cur_diff = Math.abs(sum);

                if (cur_diff < diff) {
                    diff = cur_diff;
                    res[0] = inputs[i];
                    res[1] = inputs[left];
                    res[2] = inputs[right];
                }

                if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        System.out.print(res[0] + " " + res[1] + " " + res[2]);
    }
}
