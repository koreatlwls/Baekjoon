package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P01525 {

    static String correct = "123456780";
    static Map<String, Integer> map = new HashMap<>();
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String init = "";
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int num = Integer.parseInt(st.nextToken());
                init += num;
            }
        }

        map.put(init, 0);
        System.out.print(bfs(init));
    }

    static int bfs(String init) {
        Queue<String> queue = new LinkedList<>();
        queue.add(init);

        while (!queue.isEmpty()) {
            String now = queue.poll();
            int move = map.get(now);
            int empty = now.indexOf('0');
            int nowRow = empty / 3;
            int nowCol = empty % 3;

            if (now.equals(correct)) {
                return move;
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = nowRow + dr[i];
                int nextCol = nowCol + dc[i];

                if (nextRow < 0 || nextCol < 0 || nextRow > 2 || nextCol > 2) continue;

                int nextPos = nextRow * 3 + nextCol;
                char ch = now.charAt(nextPos);
                String next = now.replace(ch, 'c');
                next = next.replace('0', ch);
                next = next.replace('c', '0');

                if (!map.containsKey(next)) {
                    queue.add(next);
                    map.put(next, move + 1);
                }
            }
        }

        return -1;
    }
}
