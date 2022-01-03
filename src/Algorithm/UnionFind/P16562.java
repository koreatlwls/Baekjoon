package Algorithm.UnionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P16562 {

    static int n, m, k;
    static int[] parents, friendFee;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        friendFee = new int[n + 1];
        parents = new int[n + 1];
        check = new boolean[n + 1];

        for (int i = 1; i < parents.length; i++) {
            parents[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < friendFee.length; i++) {
            friendFee[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        int friend = 0, answer = 0;
        for (int i = 1; i < parents.length; i++) {
            int temp = find(i);
            if (check[temp]) {
                friend++;
                continue;
            }
            if (k - friendFee[i] >= 0) {
                friend++;
                answer += friendFee[i];
                k -= friendFee[i];
                check[temp] = true;
            }

        }
        System.out.println(friend == n ? answer : "Oh no");

    }

    public static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot < bRoot) parents[bRoot] = aRoot;
        else parents[aRoot] = bRoot;

        if (friendFee[aRoot] < friendFee[bRoot]) friendFee[bRoot] = friendFee[aRoot];
        else friendFee[aRoot] = friendFee[bRoot];
    }

    public static int find(int x) {
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }
}
