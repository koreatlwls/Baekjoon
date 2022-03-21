package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P16932 {

    static int N, M;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Shape {
        int row;
        int col;

        public Shape(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int groupN = 2;
        int[] sumOfGroup = new int[500002];
        Queue<Shape> zeroQ = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    makeGroup(map, new Shape(i, j), groupN, sumOfGroup);
                    groupN++;
                } else if (map[i][j] == 0) {
                    zeroQ.add(new Shape(i, j));
                }
            }
        }

        int solution = 0;
        while (!zeroQ.isEmpty()) {
            Shape curShape = zeroQ.poll();
            solution = Math.max(solution, sumOfMerge(map, new Shape(curShape.row, curShape.col), sumOfGroup));
        }
        System.out.print(solution);
    }

    static int sumOfMerge(int[][] map, Shape startShape, int[] sumOfGroup) {
        int row = startShape.row;
        int col = startShape.col;

        int solution = 1;

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            int nextRow = row + dr[i];
            int nextCol = col + dc[i];

            if (nextRow >= N || nextRow < 0 || nextCol >= M || nextCol < 0) continue;
            int curGroup = map[nextRow][nextCol];
            if (curGroup > 1 && !set.contains(curGroup)) {
                solution += sumOfGroup[curGroup];
                set.add(curGroup);
            }
        }
        return solution;
    }

    static void makeGroup(int[][] map, Shape startShape, int groupN, int[] sumOfGroup) {
        Queue<Shape> queue = new LinkedList<>();
        queue.add(startShape);

        int sum = 0;
        while (!queue.isEmpty()) {
            Shape now = queue.poll();
            int nowRow = now.row;
            int nowCol = now.col;

            if (map[nowRow][nowCol] != 1) continue;
            map[nowRow][nowCol] = groupN;
            sum++;

            for (int i = 0; i < 4; i++) {
                int nextRow = nowRow + dr[i];
                int nextCol = nowCol + dc[i];

                if (nextRow >= N || nextRow < 0 || nextCol >= M || nextCol < 0) continue;
                if (map[nextRow][nextCol] == 1) {
                    queue.add(new Shape(nextRow, nextCol));
                }
            }
        }
        sumOfGroup[groupN] = sum;
    }
}
