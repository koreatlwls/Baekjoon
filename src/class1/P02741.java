package class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P02741 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int i;
        int num = Integer.parseInt(br.readLine());

        for (i = 1; i <= num; i++) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}
