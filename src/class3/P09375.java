package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class P09375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int result = 1;
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();

            for (int j = 0; j < n; j++) {
                String[] input = br.readLine().split(" ");
                if (map.containsKey(input[1])) {
                    map.put(input[1], map.get(input[1]) + 1);
                } else {
                    map.put(input[1], 1);
                }
            }

            for (int val : map.values()) {
                result *= (val + 1);
            }
            sb.append(result - 1).append("\n");
        }
        System.out.print(sb);
    }
}
