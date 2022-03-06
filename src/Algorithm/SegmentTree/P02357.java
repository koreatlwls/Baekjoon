package Algorithm.SegmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P02357 {

    static int[] input;
    static int[] treeMax;
    static int[] treeMin;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        input = new int[N + 1];
        treeMax = new int[4 * N];
        treeMin = new int[4 * N];

        for (int i = 1; i <= N; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        initMax(1, N, 1);
        initMin(1, N, 1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int max = maxTree(1, N, 1, a, b);
            int min = minTree(1, N, 1, a, b);
            sb.append(min).append(" ").append(max).append("\n");
        }

        System.out.print(sb);
    }

    static int initMax(int start, int end, int node) {
        if (start == end) return treeMax[node] = input[start];

        int mid = (start + end) / 2;
        return treeMax[node] = Math.max(initMax(start, mid, 2 * node), initMax(mid + 1, end, 2 * node + 1));
    }

    static int initMin(int start, int end, int node) {
        if (start == end) return treeMin[node] = input[start];

        int mid = (start + end) / 2;
        return treeMin[node] = Math.min(initMin(start, mid, 2 * node), initMin(mid + 1, end, 2 * node + 1));
    }

    static int maxTree(int start, int end, int node, int left, int right) {
        if (left > end || right < start) return Integer.MIN_VALUE;

        if (start >= left && end <= right) return treeMax[node];

        int mid = (start + end) / 2;
        return Math.max(maxTree(start, mid, node * 2, left, right), maxTree(mid + 1, end, node * 2 + 1, left, right));
    }

    static int minTree(int start, int end, int node, int left, int right) {
        if (left > end || right < start) return Integer.MAX_VALUE;

        if (start >= left && end <= right) return treeMin[node];

        int mid = (start + end) / 2;
        return Math.min(minTree(start, mid, node * 2, left, right), minTree(mid + 1, end, node * 2 + 1, left, right));
    }
}
