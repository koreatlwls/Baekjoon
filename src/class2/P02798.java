package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P02798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int a, b, c, max = 0;

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        int arr[] = new int[N];
        stringTokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        for (a = 0; a + 2 < N; a++) {
            for (b = a + 1; b + 1 < N; b++) {
                for (c = b + 1; c < N; c++) {
                    int result = arr[a] + arr[b] + arr[c];
                    if (result <= M) {
                        if (max < result) {
                            max = result;
                        }
                    }
                }
            }
        }
        System.out.print(max);
    }
}
