package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());
        int i;
        int count = 1;
        Queue<Integer> queue = new LinkedList<>();

        for (i = 0; i < N; i++) {
            queue.offer(i + 1);
        }

        sb.append("<");
        while (true) {
            if (count == K) {
                sb.append(queue.poll());
                if (queue.isEmpty()) {
                    break;
                } else {
                    sb.append(", ");
                }
                count = 1;
            } else {
                queue.offer(queue.poll());
                count++;
            }
        }
        sb.append(">");
        System.out.print(sb);
    }
}
