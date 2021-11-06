package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());
        int result = fact(N) / (fact(K) * fact(N - K));

        System.out.print(result);
    }

    public static int fact(int n) {
        if (n == 0)
            return 1;
        else
            return fact(n - 1) * n;
    }
}
