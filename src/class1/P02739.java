package class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P02739 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int i;
        int num = Integer.parseInt(br.readLine());

        for(i=1; i<10; i++){
            sb.append(num).append(" * ").append(i).append(" = ").append(num * i).append("\n");
        }
        System.out.print(sb);
    }
}
