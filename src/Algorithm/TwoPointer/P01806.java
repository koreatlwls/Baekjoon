package Algorithm.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P01806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long S = Long.parseLong(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 100001;
        int sum = 0;

        int firstPointer = 0;
        int secondPointer = 0;

        while (true) {
            if (sum >= S) {
                sum -= arr[firstPointer++];
                ans = Math.min(ans, (secondPointer - firstPointer) + 1);
            } else if (secondPointer == N) break;
            else sum += arr[secondPointer++];
        }

        System.out.print(ans == 100001 ? 0 : ans);
    }
}
