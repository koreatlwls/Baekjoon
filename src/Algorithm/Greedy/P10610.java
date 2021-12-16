package Algorithm.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        int[] numCountArr = new int[10];
        long total = 0;

        for (int i = 0; i < input.length(); i++) {
            int num = input.charAt(i) - '0';
            numCountArr[num]++;
            total += num;
        }

        if (!input.contains("0") || total % 3 != 0) {
            System.out.print("-1");
            return;
        }

        for (int i = 9; i >= 0; i--) {
            while (numCountArr[i] > 0) {
                sb.append(i);
                numCountArr[i]--;
            }
        }

        System.out.print(sb);
    }
}
