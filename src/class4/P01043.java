package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class P01043 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        boolean[] people_know = new boolean[n+1];

        HashSet<Integer>[] parties = new HashSet[m+1];
        for (int i = 1; i <= m; i++) {
            parties[i] = new HashSet<>();
        }

        inputs = br.readLine().split(" ");
        int know_num = Integer.parseInt(inputs[0]);

        for (int i = 1; i <= know_num; i++) {
            int tmp = Integer.parseInt(inputs[i]);
            people_know[tmp] = true;
        }

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int p = 1; p <= m; p++) {

            inputs = br.readLine().split(" ");
            int party_num = Integer.parseInt(inputs[0]);

            if(party_num<=1) {
                parties[p].add(Integer.parseInt(inputs[1]));
                continue;
            }

            for (int j = 1; j < party_num; j++) {
                int a = Integer.parseInt(inputs[j]);
                int b = Integer.parseInt(inputs[j+1]);
                if (find(a) != find(b)) {
                    union(a,b);
                }

                parties[p].add(a);
                parties[p].add(b);
            }
        }

        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if(people_know[i] && !visited[i]){
                int root = find(i);
                for (int j = 1; j <= n; j++){
                    if (find(j)==root) {
                        people_know[j] = true;
                        visited[j] = true;
                    }
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= m; i++) {
            boolean flag = false;
            for (int person : parties[i]) {
                if(people_know[person]){
                    flag = true;
                    break;
                }
            }
            if(!flag) result++;
        }

        System.out.println(result);
    }

    public static int find(int idx) {
        if(parent[idx]==idx){
            return idx;
        }
        parent[idx] = find(parent[idx]);
        return parent[idx];
    }

    public static void union(int a, int b) {
        int parent_b = find(b);
        parent[parent_b] = a;
    }
}
