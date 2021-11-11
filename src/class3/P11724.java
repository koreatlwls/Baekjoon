package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P11724 {

    static boolean visited[];
    static LinkedList<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        visited = new boolean[N + 1];
        adjList = new LinkedList[N + 1];
        for (int i = 0; i <= N; i++) {
            adjList[i] = new LinkedList<>();
        }

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());
            adjList[x].add(y);
            adjList[y].add(x);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(adjList[i]);
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs_list(i);
                count++;
            }
        }
        System.out.print(count);
    }

    static void dfs_list(int v) {
        visited[v] = true;
        Iterator<Integer> iter = adjList[v].listIterator();

        while (iter.hasNext()) {
            int w = iter.next();
            if (!visited[w])
                dfs_list(w);
        }
    }
}
