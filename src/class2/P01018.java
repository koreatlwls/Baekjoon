package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P01018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        char startB[][] = new char[50][50];
        char startW[][] = new char[50][50];
        char inputArr[][] = new char[n][m];
        int startBCount = 0;
        int startWCount = 0;
        int min = 65;
        String input;
        int i, j;

        for (i = 0; i < 8; i++) {
            for (j = 0; j < 8; j++) {
                if ((j & 1) == 0 && (i & 1) == 0) {
                    startB[i][j] = 'B';
                    startW[i][j] = 'W';
                } else if ((j & 1) == 0 && (i & 1) != 0) {
                    startB[i][j] = 'W';
                    startW[i][j] = 'B';
                } else if ((j & 1) != 0 && (i & 1) == 0) {
                    startB[i][j] = 'W';
                    startW[i][j] = 'B';
                } else {
                    startB[i][j] = 'B';
                    startW[i][j] = 'W';
                }
            }
        }

        for (i = 0; i < n; i++) {
            input = br.readLine();
            for (j = 0; j < m; j++) {
                inputArr[i][j] = input.charAt(j);
            }
        }

        for (int a = 0; a <= n - 8; a++) {
            for (int b = 0; b <= m - 8; b++) {
                for (i = 0; i < 8; i++) {
                    for (j = 0; j < 8; j++) {
                        if (inputArr[i + a][j + b] != startB[i][j])
                            startBCount++;
                    }
                }

                for (i = 0; i < 8; i++) {
                    for (j = 0; j < 8; j++) {
                        if (inputArr[i + a][j + b] != startW[i][j])
                            startWCount++;
                    }
                }
                if (min > startBCount)
                    min = startBCount;
                if (min > startWCount)
                    min = startWCount;
                startBCount = 0;
                startWCount = 0;
            }
        }
        System.out.print(min);
    }
}
