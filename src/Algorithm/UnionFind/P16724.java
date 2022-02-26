package Algorithm.UnionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P16724 {

    static int N, M;
    static char[][] map;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        parents = new int[N * M];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int curIdx = i * M + j;
                int nextIdx = findIdx(i, j);
                if (find(curIdx) != find(nextIdx)) {
                    union(curIdx, nextIdx);
                }
            }
        }

        int ans = findSaveZone();
        System.out.print(ans);
    }

    static int findSaveZone() {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < parents.length; i++) {
            set.add(find(i));
        }

        return set.size();
    }

    static int findIdx(int x, int y) {
        int nx = x;
        int ny = y;

        if (map[x][y] == 'U') {
            nx--;
        } else if (map[x][y] == 'D') {
            nx++;
        } else if (map[x][y] == 'L') {
            ny--;
        } else if (map[x][y] == 'R') {
            ny++;
        }

        return nx * M + ny;
    }

    static int find(int idx) {
        if (parents[idx] == idx) {
            return idx;
        }

        return parents[idx] = find(parents[idx]);
    }

    static void union(int idx1, int idx2) {
        idx1 = find(idx1);
        idx2 = find(idx2);

        if (idx1 > idx2) {
            parents[idx1] = idx2;
        } else {
            parents[idx2] = idx1;
        }
    }
}
