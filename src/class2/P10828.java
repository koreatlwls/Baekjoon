package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        int i;

        for (i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            String input = stringTokenizer.nextToken();

            switch (input) {
                case "push":
                    int a = Integer.parseInt(stringTokenizer.nextToken());
                    stack.push(a);
                    break;
                case "pop":
                    if (stack.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(stack.pop()).append("\n");
                    }
                    break;
                case "top":
                    if (stack.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(stack.peek()).append("\n");
                    }
                    break;
                case "empty":
                    if (stack.isEmpty()) {
                        sb.append("1\n");
                    } else {
                        sb.append("0\n");
                    }
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
            }
        }
        System.out.print(sb);
    }
}
