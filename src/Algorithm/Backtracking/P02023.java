package Algorithm.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P02023 {

    static int n;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dfs(0,"");
        System.out.print(sb);
    }

    static void dfs(int idx ,String prime){
        if(idx == n){
            sb.append(prime).append("\n");
            return;
        }

        for(int i=1;i<=9;i++){
            if(isPrime(Integer.valueOf(prime+i))){
                dfs(idx+1, prime+i);
            }
        }
    }

    static boolean isPrime(int num) {
        if(num == 1) return false;

        int sqrt = (int) Math.sqrt(num);
        for(int i = 2; i <= sqrt; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}
