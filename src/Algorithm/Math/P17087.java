package Algorithm.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P17087 {

    static int n, s;
    static int[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        input = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            input[i] = Math.abs(s - a);
        }

        int gcd = input[0];
        for (int i = 1; i < n; i++) {
            gcd = GCD(gcd, input[i]);
        }

        System.out.print(gcd);
    }

    static int GCD(int a, int b) {
        if (b == 0) return a;
        else return GCD(b, a % b);
    }
}
