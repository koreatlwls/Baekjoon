package Algorithm.LIS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P02352 {

    static int N;
    static int[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        int[] list = new int[N];
        list[0] = input[0];
        int idx = 1;
        int tmp = 0;

        for (int i = 1; i < N; i++) {
            if (list[idx - 1] < input[i]) {
                list[idx++] = input[i];
            } else if (list[0] > input[i]) {
                list[0] = input[i];
            } else {
                tmp = Arrays.binarySearch(list, 0, idx, input[i]);
                list[tmp < 0 ? (-tmp - 1) : tmp] = input[i];
            }
        }

        System.out.print(idx);
    }
}
