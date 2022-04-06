package Algorithm.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P01990 {

    static int A,B;
    static boolean[] isPrime = new boolean[100000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st= new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        eratos();

        for(int i=A;i<=B;i++){
            if(!isPrime[i] && isPalindrome(i)){
                sb.append(i).append("\n");
            }
        }
        sb.append(-1);
        System.out.print(sb);
    }

    static void eratos(){
        isPrime[0] = isPrime[1] = true;

        for(int i=2;i*i <=100000000; i++){
            if(!isPrime[i]){
                for(int j=i*i;j<=100000000;j+=i){
                    isPrime[j] = true;
                }
            }
        }
    }

    static boolean isPalindrome(int n){
        String t = String.valueOf(n);

        for(int i=0;i<t.length()/2;i++){
            if(t.charAt(i) != t.charAt(t.length()-i-1)){
                return false;
            }
        }

        return true;
    }
}
