package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class P02479 {
    static int[][] graph;
    static int N;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        String[] binary = new String[N+1];
        graph = new int [N+1][N+1];

        for(int i=1; i<=N; i++) {
            binary[i] = br.readLine();
        }

        String[] input = br.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);

        for(int i=1; i<=N; i++) {
            for(int j=i; j<=N; j++) {
                if(i==j)
                    graph[i][j] = 0;

                else {
                    int cnt = 0;

                    for(int k=0; k<M; k++) {
                        if(binary[i].charAt(k)!=binary[j].charAt(k))
                            cnt++;
                    }

                    if(cnt==1) {
                        graph[i][j]=1;
                        graph[j][i]=1;
                    }

                    else {
                        graph[i][j]=0;
                        graph[j][i]=0;
                    }
                }
            }
        }
        bfs(start, end);
    }

    static void bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        int[] from = new int[N+1];
        int current = 0;
        visited[start] = true;
        from[start] = -1;
        queue.add(start);

        while(!queue.isEmpty()) {
            current = queue.poll();

            if(current==end)
                break;

            for(int i=1; i<=N; i++) {
                if(!visited[i] && graph[current][i]==1) {
                    visited[i] = true;
                    from[i]=current;
                    queue.add(i);
                }
            }
        }
        if(current != end)
            System.out.println(-1);
        else {
            list.add(end);
            int i=0;
            while(true) {
                int index = list.get(i);
                if(index==start)
                    break;
                list.add(from[index]);
                i++;
            }
            for(int j=list.size()-1; j>=0; j--)
                System.out.print(list.get(j)+" ");
        }
    }
}
