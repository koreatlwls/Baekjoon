package Algorithm.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class P01174 {

    static int N;
    static int[] num = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    static ArrayList<Long> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        dfs(0, 0);
        Collections.sort(arr);

        if (N > 1023)
            System.out.print(-1);
        else
            System.out.print(arr.get(N - 1));
    }

    static void dfs(long sum, int idx) {
        if (!arr.contains(sum)) {
            arr.add(sum);
        }

        if (idx >= 10)
            return;

        dfs(sum * 10 + num[idx], idx + 1);
        dfs(sum, idx + 1);
    }
}
