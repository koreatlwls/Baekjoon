package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P14502 {

    static int N, M, max;
    static int[][] map;
    static int[][] wall;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static ArrayList<virusPoint> virusList;

    static class virusPoint {
        int row;
        int col;

        virusPoint(int row, int col) {
            super();
            this.row = row;
            this.col = col;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        virusList = new ArrayList<virusPoint>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        max = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    virusList.add(new virusPoint(i, j));
                }
            }
        }

        wall = copy(map);

        makeWall(0);

        System.out.println(max);
    }

    static boolean isValid(int row, int col) {
        if (row < 0 || row >= N || col < 0 || col >= M)
            return false;
        return true;
    }

    static int[][] copy(int[][] arr) {
        int[][] copy = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy[i][j] = arr[i][j];
            }
        }
        return copy;
    }

    static void makeWall(int depth) {

        if (depth == 3) {
            spreadVirus();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (wall[i][j] == 0) {
                    wall[i][j] = 1;
                    makeWall(depth + 1);
                    wall[i][j] = 0;
                }
            }
        }
    }

    static void spreadVirus() {

        int[][] copyWall = copy(wall);

        Queue<virusPoint> vq = new LinkedList<virusPoint>();
        for (int i = 0; i < virusList.size(); i++) {
            vq.offer(new virusPoint(virusList.get(i).row, virusList.get(i).col));
        }

        while (!vq.isEmpty()) {
            int row = vq.peek().row;
            int col = vq.poll().col;

            for (int k = 0; k < 4; k++) {
                int nextRow = row + dy[k];
                int nextCol = col + dx[k];

                if (isValid(nextRow, nextCol) && copyWall[nextRow][nextCol] == 0) {
                    copyWall[nextRow][nextCol] = 2;
                    vq.offer(new virusPoint(nextRow, nextCol));
                }

            }
        }

        int sc = countSafe(copyWall);
        max = Math.max(max, sc);
    }

    static int countSafe(int[][] copyWall) {
        int sc = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyWall[i][j] == 0) {
                    sc++;
                }
            }
        }
        return sc;
    }
}