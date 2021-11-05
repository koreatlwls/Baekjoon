package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P01929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        boolean prime[] = new boolean[n + 1];

        checkPrime(prime);
        for (int i = m; i <= n; i++) {
            if (prime[i] == false) {
                sb.append(i).append("\n");
            }
        }
        System.out.print(sb);
    }

    public static void checkPrime(boolean prime[]) {
        int n = prime.length - 1;
        if (n < 2)
            return;
        prime[0] = prime[1] = true;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (prime[i] == true)
                continue;
            for (int j = i * i; j <= n; j += i) {
                prime[j] = true;
            }
        }
    }
}
