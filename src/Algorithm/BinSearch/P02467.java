package Algorithm.BinSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P02467 {

    static int N;
    static int[] input;
    static int result1 = 0, result2 = 0;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        input = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N - 1; i++) {
            binSearch(input[i], i + 1, N-1);
        }

        System.out.print(result1 + " " + result2);
    }

    static void binSearch(int temp, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;

            int sum = temp + input[mid];

            if (sum < 0) {
                sum *= -1;
                if (min > sum) {
                    min = sum;
                    result1 = temp;
                    result2 = input[mid];
                }

                start = mid + 1;
            } else {
                if (min > sum) {
                    min = sum;
                    result1 = temp;
                    result2 = input[mid];
                }

                end = mid - 1;
            }
        }
    }
}
