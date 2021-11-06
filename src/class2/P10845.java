package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Queue<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        int i;
        int last = 0;

        for (i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            String input = stringTokenizer.nextToken();

            switch (input) {
                case "push":
                    int value = Integer.parseInt(stringTokenizer.nextToken());
                    queue.offer(value);
                    last = value;
                    break;
                case "pop":
                    if (queue.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(queue.poll()).append("\n");
                    }
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    if (queue.isEmpty()) {
                        sb.append("1\n");
                    } else {
                        sb.append("0\n");
                    }
                    break;
                case "front":
                    if (queue.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(queue.peek()).append("\n");
                    }
                    break;
                case "back":
                    if (queue.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(last).append("\n");
                    }
                    break;
            }
        }
        System.out.print(sb);
    }
}
