package Algorithm.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P13975 {

    static int N;
    static Long result;
    static PriorityQueue<Long> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            N = Integer.parseInt(br.readLine());
            pq = new PriorityQueue<>();
            result = (long)0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                pq.add(Long.parseLong(st.nextToken()));
            }

            while(pq.size()>1){
                Long num1 = pq.poll();
                Long num2 = pq.poll();

                Long sum = num1 + num2;
                result += sum;

                pq.add(sum);
            }

            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }
}
