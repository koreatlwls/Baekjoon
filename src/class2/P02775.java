package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P02775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int apt[][];
        int x, y, a, b, c;

        for (x = 0; x < T; x++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            apt = new int[k + 1][n + 1];

            for (y = 1; y <= n; y++) {
                apt[0][y] = y;
            }

            for (a = 1; a <= k; a++) {
                for (b = 1; b <= n; b++) {
                    for (c = 1; c <= b; c++) {
                        apt[a][b] += apt[a - 1][c];
                    }
                }
            }
            sb.append(apt[k][n]).append("\n");
        }
        System.out.print(sb);
    }
}
