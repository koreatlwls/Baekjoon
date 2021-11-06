package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P07568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int i, j;
        int N = Integer.parseInt(br.readLine());
        int arr[][] = new int[N][2];
        int result[] = new int[N];
        Arrays.fill(result, 1);
        for (i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            arr[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }
        for (i = 0; i < N; i++) {
            for (j = 0; j < N; j++) {
                if (i == j)
                    continue;
                if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1])
                    result[i]++;
            }
            sb.append(result[i]).append("\n");
        }
        System.out.print(sb);
    }
}
