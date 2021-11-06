package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P09012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int i;

        int T = Integer.parseInt(br.readLine());
        for (i = 0; i < T; i++) {
            sb.append(check(br.readLine())).append("\n");
        }
        System.out.print(sb);
    }

    public static String check(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(c);
            } else if (stack.empty()) {
                return "NO";
            } else {
                stack.pop();
            }
        }
        if (stack.empty()) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
