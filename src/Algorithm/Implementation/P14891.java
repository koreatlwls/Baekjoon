package Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14891 {

    static int[][] wheel = new int[4][8];
    static int[] isValid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < 8; j++) {
                wheel[i][j] = Integer.parseInt(input[j]);
            }
        }

        int round = Integer.parseInt(br.readLine());

        for (int i = 0; i < round; i++) {
            isValid = new int[4];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int wheelNum = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());

            check(wheelNum, dir);
            rotate(isValid);
        }

        System.out.print(calc());
    }

    static void check(int wheelNum, int dir) {
        isValid[wheelNum] = dir;

        int prev = wheelNum - 1;
        int next = wheelNum + 1;

        if (prev >= 0 && isValid[prev] == 0) {
            if (wheel[prev][2] != wheel[wheelNum][6]) {
                check(prev, dir * -1);
            }
        }

        if (next <= 3 && isValid[next] == 0) {
            if (wheel[next][6] != wheel[wheelNum][2]) {
                check(next, dir * -1);
            }
        }
    }

    static void rotate(int[] isValid) {
        for (int i = 0; i < 4; i++) {
            if (isValid[i] != 0) {
                int[] temp = new int[8];

                int idx;
                for (int j = 0; j < 8; j++) {
                    idx = j + isValid[i];

                    if (idx == -1) {
                        idx = 7;
                    } else if (idx == 8) {
                        idx = 0;
                    }

                    temp[idx] = wheel[i][j];
                }

                wheel[i] = temp;
            }
        }
    }

    static int calc() {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            int num = wheel[i][0];

            if (num == 1) {
                sum += Math.pow(2, i);
            }
        }

        return sum;
    }
}
