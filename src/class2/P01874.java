package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P01874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int start = 0;

        for (int i = 0; i < num; i++) {
            int input = Integer.parseInt(br.readLine());

            if (input > start) {
                for (int j = start + 1; j <= input; j++) {
                    stack.push(j);
                    sb.append('+').append('\n');
                }
                start = input;
            } else if (stack.peek() != input) {
                System.out.print("NO");
                return;
            }

            stack.pop();
            sb.append('-').append('\n');
        }
        System.out.print(sb);
    }
}
