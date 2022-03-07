package Algorithm.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P02879 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] target = new int[N];
        int prev = 0;
        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            target[i] = Integer.parseInt(st.nextToken())-target[i];
        }

        if(N>1) {
            prev = target[0];
            for (int i = 1; i < N; i++) {
                if(prev*target[i]<0){
                    answer += Math.abs(prev);
                }else if(Math.abs(prev)>=Math.abs(target[i])){
                    answer += Math.abs(prev)-Math.abs(target[i]);
                }
                prev = target[i];
            }
        }else{
            answer = target[0];
        }

        answer += Math.abs(prev);
        System.out.println(answer);
    }
}
