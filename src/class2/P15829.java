package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P15829 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int i;
        String str = br.readLine();
        long sum = 0;
        double r = 0;
        r = Math.pow(31, 0);
        for (i = 0; i < N; i++) {
            sum += (str.charAt(i) - 96) * r;
            r = r * 31 % 1234567891;
        }
        System.out.print(sum % 1234567891);
    }
}
