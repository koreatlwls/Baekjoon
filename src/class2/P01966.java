package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P01966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int i, j, k, x;
        int num = Integer.parseInt(br.readLine());

        for (i = 0; i < num; i++) {
            StringTokenizer stringTokenizer1 = new StringTokenizer(br.readLine());
            StringTokenizer stringTokenizer2 = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(stringTokenizer1.nextToken());
            int M = Integer.parseInt(stringTokenizer1.nextToken());

            LinkedList<int[]> q = new LinkedList<>();
            for (j = 0; j < N; j++) {
                q.offer(new int[]{j, Integer.parseInt(stringTokenizer2.nextToken())});
            }

            int count = 0;

            while (!q.isEmpty()) {
                int[] front = q.poll();
                boolean isMax = true;

                for (k = 0; k < q.size(); k++) {
                    if (front[1] < q.get(k)[1]) {
                        q.offer(front);
                        for (x = 0; x < k; x++) {
                            q.offer(q.poll());
                        }
                        isMax = false;
                        break;
                    }
                }

                if (isMax == false)
                    continue;

                count++;
                if(front[0] == M)
                    break;
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
}
