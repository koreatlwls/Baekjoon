package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P01978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean prime[] = new boolean[1000 + 1];
        checkPrime(prime);

        int num = Integer.parseInt(br.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int count = 0;

        for (int i = 0; i < num; i++) {
            int input = Integer.parseInt(stringTokenizer.nextToken());
            if (!prime[input]) {
                count++;
            }
        }
        System.out.print(count);
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
