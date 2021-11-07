package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int B = Integer.parseInt(stringTokenizer.nextToken());

        int[][] ground = new int[N][M];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < ground.length; i++) {
            String[] groundRow = br.readLine().split(" ");

            for (int j = 0; j < M; j++) {
                int value = Integer.parseInt(groundRow[j]);
                ground[i][j] = value;
                max = Math.max(max, value);
                min = Math.min(min, value);
            }
        }

        int answerSeconds = Integer.MAX_VALUE;
        int answerHeight = -1;

        for (int i = min; i <= max; i++) {
            int seconds = 0;
            int inventory = B;

            for (int j = 0; j < ground.length; j++) {
                for (int k = 0; k < ground[j].length; k++) {
                    int diff = ground[j][k] - i;

                    if (diff > 0) {
                        seconds += Math.abs(diff) * 2;
                        inventory += Math.abs(diff);
                    } else if (diff < 0) {
                        seconds += Math.abs(diff);
                        inventory -= Math.abs(diff);
                    }
                }
            }

            if (inventory >= 0) {
                if (seconds <= answerSeconds) {
                    answerSeconds = seconds;
                    answerHeight = i;
                }
            }
        }
        System.out.printf("%d %d", answerSeconds, answerHeight);
    }
}
