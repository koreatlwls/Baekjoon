package Algorithm.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P07490 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int number = Integer.parseInt(br.readLine());
            dfs(number, 1, 1, 1, 0, "1");
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int max, int now, int num, int sign, int sum, String str) {
        if (max == now) {
            sum = sum + (num * sign);
            if (sum == 0) {
                sb.append(str + "\n");
            }
            return;
        }
        dfs(max, now + 1, num * 10 + (now + 1), sign, sum, str + " " + String.valueOf(now + 1));
        dfs(max, now + 1, now + 1, 1, sum + (num * sign), str + "+" + String.valueOf(now + 1));
        dfs(max, now + 1, now + 1, -1, sum + (num * sign), str + "-" + String.valueOf(now + 1));
    }
}