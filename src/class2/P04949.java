package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P04949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input;

        while (true) {
            input = br.readLine();
            if (input.equals("."))
                break;
            sb.append(check(input)).append("\n");
        }
        System.out.print(sb);
    }

    public static String check(String input) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '(' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.empty() || stack.peek() != '(') {
                    return "no";
                } else {
                    stack.pop();
                }
            } else if (c == ']') {
                if (stack.empty() || stack.peek() != '[') {
                    return "no";
                } else {
                    stack.pop();
                }
            }
        }
        if (stack.empty()) {
            return "yes";
        } else {
            return "no";
        }
    }
}
