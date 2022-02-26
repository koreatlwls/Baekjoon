package Algorithm.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01013 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            String input = br.readLine();
            String regex = "(100+1+|01)+";

            if(input.matches(regex))
                sb.append("YES").append("\n");
            else
                sb.append("NO").append("\n");
        }

        System.out.print(sb);
    }
}
