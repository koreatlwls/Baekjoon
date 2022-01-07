package Algorithm.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P05052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            String[] phoneNumber = new String[N];

            for (int i = 0; i < N; i++) {
                phoneNumber[i] = br.readLine();
            }

            Arrays.sort(phoneNumber);

            if (isConsistent(N, phoneNumber)) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }

        System.out.print(sb);
    }

    static boolean isConsistent(int N, String[] phoneNumber) {
        for (int i = 0; i < N - 1; i++) {
            if (phoneNumber[i + 1].startsWith(phoneNumber[i])) {
                return false;
            }
        }

        return true;
    }
}
