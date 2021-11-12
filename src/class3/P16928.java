package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P16928 {

    static int N;
    static int M;
    static int ladder[] = new int[110];
    static int snake[] = new int[110];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        for (int i = 1; i <= N; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            ladder[a] = b;
        }

        for (int i = 1; i <= M; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            snake[a] = b;
        }

        System.out.print(bfs(1));
    }

    static int bfs(int v) {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int value = queue.poll();
                if(value ==100)
                    return count;

                int addCnt = 0;
                for (int j = 6; j >= 1; j--) {
                    if (value + j > 100) {
                        continue;
                    } else {
                        if (checkLadder(value + j)) {
                            queue.add(ladder[value + j]);
                        } else if (checkSnake(value + j)) {
                            queue.add(snake[value + j]);
                        } else if (addCnt == 0) {
                            queue.add(value + j);
                            addCnt++;
                        }
                    }
                }
            }
            count++;
        }
        return count;
    }

    static boolean checkSnake(int v) {
        if (snake[v] > 0)
            return true;
        else
            return false;
    }

    static boolean checkLadder(int v) {
        if (ladder[v] > 0)
            return true;
        else
            return false;
    }
}
