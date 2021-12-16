package Algorithm.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class P01026 {

    static int n;
    static int[] arrA;
    static Integer[] arrB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        arrA = new int[n];
        arrB = new Integer[n];

        StringTokenizer stA = new StringTokenizer(br.readLine());
        StringTokenizer stB = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            arrA[i] = Integer.parseInt(stA.nextToken());
            arrB[i] = Integer.parseInt(stB.nextToken());
        }

        Arrays.sort(arrA);
        Arrays.sort(arrB, Collections.reverseOrder());

        int sum = 0;
        for(int i=0;i<n;i++){
            sum += arrA[i] * arrB[i];
        }
        System.out.print(sum);
    }
}
