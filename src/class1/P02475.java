package class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P02475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int i;
        int[] arr = new int[5];
        int result = 0;

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        for (i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
            result += arr[i] * arr[i];
        }
        System.out.println(result % 10);
    }
}
