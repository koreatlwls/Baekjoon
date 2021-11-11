package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class P11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if(input == 0){
                if(priorityQueue.isEmpty()){
                    sb.append("0\n");
                }else{
                    sb.append(priorityQueue.poll()).append("\n");
                }
            }else {
                priorityQueue.add(input);
            }
        }
        System.out.print(sb);
    }
}
