package class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P03052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int i;
        int[] arr = new int[10];
        int[] remainder = new int[42];
        int result = 0;

        for (i = 0; i < 10; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            remainder[arr[i] % 42]++;
        }
        for (i = 0; i < remainder.length; i++) {
            if (remainder[i] > 0)
                result++;
        }
        System.out.print(result);
    }
}
