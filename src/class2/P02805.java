package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P02805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(br.readLine());
        int input[] = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(input);
        System.out.print(binarySearch(input, M, 1, input[input.length - 1]));
    }

    public static long binarySearch(int arr[], int target, long start, long end) {
        long mid;
        long max = 0;
        long result = 0;

        while (start <= end) {
            mid = (start + end) / 2;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > mid)
                    result += arr[i] - mid;
            }

            if (result >= target) {
                max = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            result = 0;
        }
        return max;
    }
}
