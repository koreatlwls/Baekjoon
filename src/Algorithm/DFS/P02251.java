package Algorithm.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class P02251 {

    static int[] limit;
    static boolean[][] visited;
    static Set<Integer> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        limit = new int[3];
        visited = new boolean[201][201];
        for(int i=0;i<3;i++){
            limit[i] = Integer.parseInt(st.nextToken());
        }

        answer = new TreeSet<>();
        dfs(0,0,limit[2]);

        for(int num: answer){
            System.out.print(num + " ");
        }
    }

    static void dfs(int a, int b, int c){
        if(visited[a][b])return;

        if(a==0){
            answer.add(c);
        }
        visited[a][b] = true;

        if(a+b > limit[1]){
            dfs((a+b)-limit[1],limit[1], c);
        }else{
            dfs(0,a+b,c);
        }

        if(a+b > limit[0]) {
            dfs(limit[0], a+b-limit[0], c);
        }else {
            dfs(a+b, 0, c);
        }

        if(a+c > limit[0]) {
            dfs(limit[0], b, a+c-limit[0]);
        }else {
            dfs(a+c, b, 0);
        }

        if(b+c > limit[1]) 	{
            dfs(a, limit[1], b+c-limit[1]);
        }else {
            dfs(a, b+c, 0);
        }

        dfs(a, 0, b+c);
        dfs(0, b, a+c);
    }
}
