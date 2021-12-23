package Algorithm.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P05567 {

    static int n,m;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> list;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        visited = new boolean[n+1];
        list = new ArrayList<>();
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        visited[1] = true;
        dfs(1,0);

        for(int i=2;i<=n;i++){
            if(visited[i])ans++;
        }
        System.out.print(ans);
    }

    static void dfs(int start, int count){
        if(count ==2){
            return;
        }

        for(int i=0;i<list.get(start).size();i++){
            int next = list.get(start).get(i);
            visited[next] = true;
            dfs(next, count+1);
        }
    }
}
