package class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P01546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int i;
        int max = 0;
        int[] arr;
        double result = 0;

        int num = Integer.parseInt(br.readLine());
        arr = new int[num];

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        for (i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
            if (max < arr[i])
                max = arr[i];
        }
        for (i = 0; i < arr.length; i++) {
            result += (double) arr[i] / max * 100;
        }
        System.out.println(result / num);
    }
}
