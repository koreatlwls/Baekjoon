package Algorithm.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P15965 {

    static int K;
    static int[] prime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        K = Integer.parseInt(br.readLine());
        setData();
        System.out.println(prime[K-1]);
    }

    static void setData(){
        prime = new int[10000001];
        boolean[] check = new boolean[100000001];

        int index = 0;

        for(int i=2;i<=10000000;++i){
            if(!check[i]){
                prime[index++] = i;
                for(int j=i+i;j<=10000000;j+=i){
                    check[j] = true;
                }
            }
        }
    }
}
