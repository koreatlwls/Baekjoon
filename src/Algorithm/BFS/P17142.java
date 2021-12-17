package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P17142 {

    static int N, M;
    static int[][] arr;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static ArrayList<Virus> viruses = new ArrayList<>();
    static Virus[] active;
    static int resultMinTime = Integer.MAX_VALUE;
    static int originEmptySpace = 0;

    static class Virus {
        int row;
        int col;
        int time;

        Virus(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        active = new Virus[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] == 0) {
                    originEmptySpace++;
                } else if (arr[i][j] == 2) {
                    viruses.add(new Virus(i, j, 0));
                }
            }
        }

        if (originEmptySpace == 0) {
            System.out.println(0);
        } else {
            selectVirus(0, 0);
            System.out.println(resultMinTime == Integer.MAX_VALUE ? -1 : resultMinTime);
        }
    }

    static void selectVirus(int start, int selectCount) {
        if (selectCount == M) {
            spreadVirus(originEmptySpace);
            return;
        }

        for (int i = start; i < viruses.size(); i++) {
            active[selectCount] = viruses.get(i);
            selectVirus(i + 1, selectCount + 1);
        }
    }

    static void spreadVirus(int emptySpace) {
        Queue<Virus> q = new LinkedList<>();
        boolean[][] infected = new boolean[N][N];

        for (int i = 0; i < M; i++) {
            Virus virus = active[i];
            infected[virus.row][virus.col] = true;
            q.offer(virus);
        }

        while (!q.isEmpty()) {
            Virus virus = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = virus.row + dr[i];
                int ny = virus.col + dc[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (infected[nx][ny] || arr[nx][ny] == 1) continue;

                if (arr[nx][ny] == 0) {
                    emptySpace--;
                }

                if (emptySpace == 0) {
                    resultMinTime = Math.min(resultMinTime, virus.time + 1);
                    return;
                }

                infected[nx][ny] = true;
                q.offer(new Virus(nx, ny, virus.time + 1));
            }
        }
    }
}
