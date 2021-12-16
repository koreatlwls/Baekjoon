package Algorithm.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P01946 {

    static int n;

    static class Grade implements Comparable<Grade>{
        int a;
        int b;

        public Grade(int a, int b){
            this.a = a;
            this.b= b;
        }

        @Override
        public int compareTo (Grade other){
            if(this.a>other.a)return 1;
            else return -1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            n = Integer.parseInt(br.readLine());
            ArrayList<Grade> list = new ArrayList<>();

            for(int i=0;i<n;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list.add(new Grade(a,b));
            }

            Collections.sort(list);

            int ans =1 ;
            int min = list.get(0).b;
            for(int i=1;i<n;i++){
                if(list.get(i).b<min){
                    ans++;
                    min = list.get(i).b;
                }
            }

            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }
}
