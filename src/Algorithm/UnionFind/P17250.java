package Algorithm.UnionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P17250 {

    static int n, m;
    static int[] planetNumArr;
    static int[] root;

    static int find(int x){
        if(x == root[x])
            return x;
        else
            return (root[x] = find(root[x]));
    }

    static int union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        if(rootX != rootY){
            root[rootX] = rootY;
            planetNumArr[rootY] += planetNumArr[rootX];
        }

        return planetNumArr[rootY];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        planetNumArr = new int[n+1];
        root = new int[n+1];

        for(int i=1;i<=n;i++){
            root[i]=i;
        }

        for (int i = 1; i <= n; i++) {
            planetNumArr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(union(a,b)).append("\n");
        }

        System.out.print(sb);
    }
}
