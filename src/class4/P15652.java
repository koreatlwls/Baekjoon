package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15652 {

    static int n,m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        backtracking(1,0);
        System.out.print(sb);
    }

    static void backtracking(int at, int depth){
        if(depth==m){
            for(int val : arr){
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=at; i<=n;i++){
            arr[depth] = i;
            backtracking(i,depth+1);
        }
    }
}
