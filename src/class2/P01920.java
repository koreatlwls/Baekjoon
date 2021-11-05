package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P01920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer stringTokenizer1 = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer stringTokenizer2 = new StringTokenizer(br.readLine());

        int input[] = new int[n];
        int i, j;

        for (i = 0; i < n; i++) {
            input[i] = Integer.parseInt(stringTokenizer1.nextToken());
        }
        Arrays.sort(input);

        for (j = 0; j < m; j++) {
            int target = Integer.parseInt(stringTokenizer2.nextToken());
            boolean result = binarySearch(input, target, 0, input.length - 1);
            if (result)
                sb.append(1).append("\n");
            else
                sb.append(0).append("\n");
        }
        System.out.print(sb);
    }

    public static boolean binarySearch(int arr[], int target, int start, int end) {
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[mid] == target)
                return true;
            else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
