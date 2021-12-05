package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P16953 {

    static long a, b;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        if (!bfs()) {
            System.out.print(-1);
        } else {
            System.out.print(count + 1);
        }
    }

    static boolean bfs() {
        Queue<Long> queue = new LinkedList<>();
        queue.offer(a);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                long now = queue.poll();

                if (now == b) {
                    return true;
                }

                for (int j = 0; j < 2; j++) {
                    long next;
                    if (j == 0) {
                        next = now * 2;
                        if(next <=1000000000){
                            queue.offer(next);
                        }
                    } else {
                        next = Long.parseLong(String.valueOf(now) + '1');
                        if(next <=1000000000){
                            queue.offer(next);
                        }
                    }
                }
            }

            count++;
        }
        return false;
    }
}
