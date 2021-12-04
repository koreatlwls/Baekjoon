package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P13172 {

    static final long MOD = 1000000007;
    static long m;
    static long n, s;
    static long result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        m = Integer.parseInt(br.readLine());
        for (long i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());

            result += getExpectedValue(n, s);
            result %= MOD;
        }

        System.out.print(result);
    }

    static long getExpectedValue(long a, long b) {
        return b * getSquaredNumber(a, MOD - 2) % MOD;
    }

    static long getSquaredNumber(long num, long exp) {
        if (exp == 1)
            return num;
        if (exp % 2 == 0) {
            long half = getSquaredNumber(num, exp / 2);
            return half * half % MOD;
        } else {
            return num * getSquaredNumber(num, exp - 1) % MOD;
        }
    }
}
