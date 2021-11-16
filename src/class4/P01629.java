package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P01629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        System.out.print(pow(A, B, C));
    }

    static long pow(long a, long b, long c) {
        if (b == 1) {
            return a % c;
        }

        long temp = pow(a, b / 2, c);

        if (b % 2 == 1) {
            return (temp * temp % c) * a % c;
        }

        return temp * temp % c;
    }
}
