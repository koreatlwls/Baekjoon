package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P02108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        int input[] = new int[num];
        int count[] = new int[8001];
        int sum = 0;
        int max = 0;
        int mode = 0;

        for (int i = 0; i < num; i++) {
            input[i] = Integer.parseInt(br.readLine());
            count[input[i] + 4000]++;
        }
        Arrays.sort(input);

        for (int a : input)
            sum += a;

        sb.append((int) Math.round((double) sum / num)).append("\n");
        sb.append(input[input.length / 2]).append("\n");
        for (int j = 0; j < count.length; j++) {
            if (max < count[j]) {
                max = count[j];
            }
        }
        int twice = 0;
        for (int k = 0; k < count.length; k++) {
            if (max == count[k]) {
                twice++;
                mode = k - 4000;
            }
            if (twice == 2) {
                mode = k - 4000;
                break;
            }
        }
        sb.append(mode).append("\n");
        sb.append(input[input.length - 1] - input[0]).append("\n");

        System.out.print(sb);
    }
}
