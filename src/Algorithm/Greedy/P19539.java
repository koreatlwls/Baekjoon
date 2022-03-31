package Algorithm.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P19539 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int tmp;
        int sum = 0;
        int num = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tmp = Integer.parseInt(st.nextToken());
            sum += tmp;
            if (tmp % 2 == 1) {
                num++;
            }
        }

        if (sum % 3 == 0 && num <= sum / 3) {
            System.out.print("YES");
        } else {
            System.out.print("NO");
        }
    }
}
