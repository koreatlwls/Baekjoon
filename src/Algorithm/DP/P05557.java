package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P05557 {

    static int N;
    static int[] number;
    static long[] count = new long[21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        number = new int[N];
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        count[number[0]] = 1;
        cal(0);
        System.out.print(count[number[N - 1]]);
    }

    static void cal(int index) {
        if (index == N - 2)
            return;

        long[] temp = new long[21];
        for (int i = 0; i <= 20; i++) {
            if (count[i] != 0) {
                if (i - number[index + 1] >= 0)
                    temp[i - number[index + 1]] += count[i];
                if (i + number[index + 1] <= 20)
                    temp[i + number[index + 1]] += count[i];
            }
        }

        count = temp.clone();
        cal(index + 1);
    }
}
