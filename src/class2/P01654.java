package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P01654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(stringTokenizer.nextToken());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int input[] = new int[k];

        for (int i = 0; i < k; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(input);
        long result = binarySearch(input, n, 1, input[input.length - 1]);
        System.out.print(result);
    }

    public static long binarySearch(int[] arr, int target, long start, long end) {
        long mid;
        int i;
        long max = 0;
        int result = 0;

        while (start <= end) {
            mid = (start + end) / 2;
            for (i = 0; i < arr.length; i++) {
                result += arr[i] / mid;
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
