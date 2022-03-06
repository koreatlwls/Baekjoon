package Algorithm.BinSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P02585 {

    static int N, K;
    static int[][] arr;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[1010][2];
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 10000;
        int mid = 0;
        int ans = 0;

        while(start <=end){
            mid = (start+end) /2;
            if( BFS(mid, 0, mid*10)){
                ans = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }

        System.out.print(ans);
    }

    static boolean BFS(int mid, int start, int canDis){
        check = new boolean[1001];

        int cnt = 0;
        double dis = 0.0;
        double disTo = 0.0;
        int num = 0;
        int size = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()){
            size = queue.size();
            if(cnt > K){
                return false;
            }

            for(int i=0;i<size;i++){
                num = queue.poll();

                if(!check[num]){
                    check[num] = true;
                    for(int j=1;j<=N;j++){
                        dis = Math.sqrt(Math.pow(arr[num][0] - arr[j][0],2)+ Math.pow(arr[num][1] - arr[j][1],2));
                        if(dis <= canDis){
                            disTo = Math.sqrt(Math.pow(10000 - arr[j][0],2)+ Math.pow(10000-arr[j][1],2));
                            if(disTo <= canDis){
                                return true;
                            }
                            queue.add(j);
                        }
                    }
                }
            }
            cnt++;
        }

        return false;
    }
}
