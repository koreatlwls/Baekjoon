package Algorithm.Floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P11780 {

    static int n,m;
    static long[][] dist;
    static int[][] next;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        dist = new long[n+1][n+1];
        next = new int[n+1][n+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                next[i][j] = -1;
                if(i==j)continue;
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i=0;i<m;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            dist[s][e] = Math.min(c,dist[s][e]);
            next[s][e] = s;
        }

        floydWarshall();
        print();
        System.out.print(sb);
    }

    static void floydWarshall(){
        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(dist[i][j] > dist[i][k] + dist[k][j]){
                        dist[i][j] = dist[i][k]+dist[k][j];
                        next[i][j] = next[k][j];
                    }
                }
            }
        }
    }

    static void print(){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(dist[i][j] >= Integer.MAX_VALUE){
                    sb.append("0 ");
                }else{
                    sb.append(dist[i][j] + " ");
                }
            }
            sb.append("\n");
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(next[i][j] == -1){
                    sb.append("0\n");
                }else{
                    Stack<Integer> path = new Stack<>();
                    int pre = j;
                    path.push(j);

                    while(i != next[i][pre]){
                        pre = next[i][pre];
                        path.push(pre);
                    }

                    sb.append(path.size() + 1 + " ");

                    sb.append(i + " ");
                    while(!path.isEmpty()){
                        sb.append(path.pop() + " ");
                    }
                    sb.append("\n");
                }
            }
        }
    }
}
