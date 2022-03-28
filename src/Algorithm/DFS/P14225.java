package Algorithm.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P14225 {

    static int N;
    static int[] input;
    static boolean[] check = new boolean[20 * 100000 + 10];
    static int answer = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        input = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        while(check[answer]){
            answer++;
        }

        System.out.print(answer);
    }

    static void dfs(int idx, int sum) {
        if (idx == N) {
            check[sum] = true;
        } else {
            dfs(idx + 1, sum + input[idx]);
            dfs(idx + 1, sum);
        }
    }
}
