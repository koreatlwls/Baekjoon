package class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10950 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int a, b;
        int num = Integer.parseInt(br.readLine());
        StringTokenizer stringTokenizer;

        for (int i = 0; i < num; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            a = Integer.parseInt(stringTokenizer.nextToken());
            b = Integer.parseInt(stringTokenizer.nextToken());
            sb.append(a + b).append("\n");
        }
        System.out.print(sb);
    }
}
