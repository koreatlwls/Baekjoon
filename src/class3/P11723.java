package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        int value = 0;
        int bitset = 0;

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            switch (input[0]){
                case "add" :
                    value = Integer.parseInt(input[1]);
                    bitset |= (1 << (value - 1));
                    break;
                case "remove" :
                    value = Integer.parseInt(input[1]);
                    bitset = bitset & ~(1 << (value - 1));
                    break;
                case "check" :
                    value = Integer.parseInt(input[1]);
                    sb.append((bitset & (1 << (value - 1))) != 0 ? "1\n" : "0\n");
                    break;
                case "toggle" :
                    value = Integer.parseInt(input[1]);
                    bitset ^= (1 << (value - 1));
                    break;
                case "all" :
                    bitset |= (~0);
                    break;
                case "empty" :
                    bitset &= 0;
                    break;
            }
        }
        System.out.print(sb);
    }
}
