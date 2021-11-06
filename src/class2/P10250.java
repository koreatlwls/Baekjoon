package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int i;
        int T = Integer.parseInt(br.readLine());
        for (i = 0; i < T; i++) {
            StringTokenizer strinTokenizer = new StringTokenizer(br.readLine());

            int H = Integer.parseInt(strinTokenizer.nextToken());
            strinTokenizer.nextToken();
            int N = Integer.parseInt(strinTokenizer.nextToken());

            if (N % H == 0) {
                sb.append((H * 100) + (N / H)).append('\n');

            } else {
                sb.append(((N % H) * 100) + ((N / H) + 1)).append('\n');
            }
        }
        System.out.print(sb);
    }
}
