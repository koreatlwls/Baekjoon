package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int i, result = 0;
        Stack<Integer> stack = new Stack<>();

        for (i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input != 0) {
                stack.push(input);
            } else {
                if (stack.isEmpty()) {
                    continue;
                } else {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        System.out.print(result);
    }
}
