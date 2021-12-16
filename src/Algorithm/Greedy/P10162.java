package Algorithm.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10162 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int[] time = {300, 60, 10};
        int[] count = new int[3];

        for (int i = 0; i < 3; i++) {
            if (time[i] > T)
                continue;
            count[i] += T / time[i];
            T %= time[i];
        }

        if (T > 0) {
            System.out.print("-1");
        } else {
            System.out.printf("%d %d %d", count[0], count[1], count[2]);
        }
    }
}
