package Algorithm.Psum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P02015 {

    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        int[] psum = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            psum[i] = psum[i-1] + arr[i];
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        long ret = 0;
        for(int i=1;i<=n;i++){
            ret += map.getOrDefault(psum[i]-k,0);
            map.put(psum[i],map.getOrDefault(psum[i],0)+1);
        }

        System.out.print(ret);
    }
}