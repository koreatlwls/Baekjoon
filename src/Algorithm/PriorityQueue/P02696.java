package Algorithm.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P02696 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());

        while(T-- >0){
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            int N = Integer.parseInt(br.readLine());

            sb.append(((N + 1) / 2) + "\n");

            int cnt = 0;

            for (int i = 0; i < N; i++) {
                if (i % 10 == 0) {
                    st = new StringTokenizer(br.readLine());
                }

                int x = Integer.parseInt(st.nextToken());

                if (maxHeap.size() == minHeap.size()) {
                    maxHeap.offer(x);
                } else {
                    minHeap.offer(x);
                }

                if (!minHeap.isEmpty()) {
                    if (maxHeap.peek() > minHeap.peek()) {
                        int t1 = maxHeap.poll();
                        int t2 = minHeap.poll();

                        maxHeap.offer(t2);
                        minHeap.offer(t1);
                    }
                }

                if (i % 2 == 0) {
                    if (cnt == 9 || i == N - 1) {
                        sb.append(maxHeap.peek() + "\n");
                        cnt = 0;
                    } else {
                        sb.append(maxHeap.peek() + " ");
                    }
                    cnt++;
                }
            }
        }

        System.out.print(sb);
    }
}
