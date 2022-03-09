package Algorithm.SegmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12837 {

    static int N, Q;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        tree = new long[4 * N];

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int check = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (check == 1) {
                update(1, N, 1, a, b);
            } else {
                sb.append(sum(1, N, 1, a, b)).append("\n");
            }
        }

        System.out.print(sb);
    }

    static long sum(int start, int end, int node, int left, int right) {
        if (left > end || right < start) return 0;

        if (start >= left && end <= right) return tree[node];

        int mid = (start + end) / 2;
        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }

    static void update(int start, int end, int node, int index, int dif) {
        if (index < start || index > end) return;

        tree[node] += dif;

        if (start == end) return;

        int mid = (start + end) / 2;

        update(start, mid, node * 2, index, dif);
        update(mid + 1, end, node * 2 + 1, index, dif);
    }
}
