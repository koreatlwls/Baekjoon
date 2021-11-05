package class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P02577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int i;
        int result = 1;
        int[] arr = new int[3];
        int[] arrResult = new int[10];

        for (i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            result *= arr[i];
        }
        while (result > 0) {
            arrResult[result % 10]++;
            result /= 10;
        }
        for (i = 0; i < arrResult.length; i++) {
            sb.append(arrResult[i] + "\n");
        }
        System.out.print(sb);
    }
}
