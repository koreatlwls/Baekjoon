package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P14267 {

    static int N, M;
    static ArrayList<Integer>[] list;
    static int[] wv;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int b = Integer.parseInt(st.nextToken());
            if (b != -1) {
                list[b].add(i);
            }
        }

        wv = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int man = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            wv[man] += w;
        }

        dfs(1);
        for (int i = 1; i <= N; i++) {
            System.out.print(wv[i] + " ");
        }
    }

    static void dfs(int idx) {
        for (int nxt : list[idx]) {
            wv[nxt] += wv[idx];
            dfs(nxt);
        }
    }
}
