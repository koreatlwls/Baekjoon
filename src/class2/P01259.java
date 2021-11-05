package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;
        boolean result = true;

        while (!(input = br.readLine()).equals("0")) {
            int len = input.length();
            for(int i =0; i<len/2; i++){
                if(input.charAt(i)!=input.charAt(len-1-i)){
                    result = false;
                    break;
                }
            }

            if (result)
                sb.append("yes\n");
            else
                sb.append("no\n");
            result = true;
        }
        System.out.print(sb);
    }
}
