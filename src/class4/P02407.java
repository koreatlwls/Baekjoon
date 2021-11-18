package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class P02407 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        BigInteger num1, num2;
        num1 = factorial(n - m).multiply(factorial(m));
        num2 = factorial(n);

        System.out.print(num2.divide(num1));
    }

    static BigInteger factorial(int n) {
        if (n == 0) return BigInteger.valueOf(1);

        BigInteger ret = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            ret = ret.multiply(BigInteger.valueOf(i));
        }
        return ret;
    }
}
