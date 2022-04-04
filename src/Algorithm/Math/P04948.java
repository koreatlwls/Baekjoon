package Algorithm.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P04948 {

    static boolean[] prime = new boolean[246913];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        get_prime();

        while(true){
            int num = Integer.parseInt(br.readLine());

            if(num == 0)break;

            int count = 0;

            for(int i=num+1; i<= 2* num; i++){
                if(!prime[i])count++;
            }

            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }

    static void get_prime(){
        prime[0] = prime[1] = true;

        for(int i=2;i<=Math.sqrt(prime.length);i++){
            if(prime[i]) continue;
            for(int j=i*i;j<prime.length;j+=i){
                prime[j] = true;
            }
        }
    }
}
