package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P02609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(stringTokenizer.nextToken());
        int b = Integer.parseInt(stringTokenizer.nextToken());

        if (a < b) {
            sb.append(GCD(a, b)).append("\n");
            sb.append(LCM(a, b)).append("\n");
        } else {
            sb.append(GCD(b, a)).append("\n");
            sb.append(LCM(b, a)).append("\n");
        }
        System.out.print(sb);
    }

    public static int GCD(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return GCD(b, a % b);
    }

    public static int LCM(int a, int b) {
        return a * b / GCD(a, b);
    }
}
