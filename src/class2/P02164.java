package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P02164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= num; i++) {
            queue.offer(i);
        }

        while (true) {
            if (queue.size() == 1) {
                System.out.print(queue.poll());
                break;
            }
            queue.poll();
            queue.offer(queue.poll());
        }
    }
}
