package Algorithm.BinSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P02470 {

    static int N;
    static int[] inputs;
    static int result1, result2;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        inputs = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(inputs);
        for (int i = 0; i < N - 1; i++) {
            binSearch(inputs[i], i + 1, N - 1);
        }

        System.out.print(result1 + " " + result2);
    }

    static void binSearch(int temp, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;

            int sum = temp + inputs[mid];

            if (sum < 0) {
                sum *= -1;
                if (MIN > sum) {
                    MIN = sum;
                    result1 = temp;
                    result2 = inputs[mid];
                }
                start = mid + 1;
            } else {
                if (MIN > sum) {
                    MIN = sum;
                    result1 = temp;
                    result2 = inputs[mid];
                }
                end = mid - 1;
            }
        }
    }
}
