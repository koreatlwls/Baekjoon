package Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14503 {

    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int cleanCount;

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static Robot robot;

    static class Robot {
        int row;
        int col;
        int dir;

        public Robot(int row, int col, int dir) {
            this.row = row;
            this.col = col;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        cleanCount = 0;

        st = new StringTokenizer(br.readLine());
        int robotRow = Integer.parseInt(st.nextToken());
        int robotCol = Integer.parseInt(st.nextToken());
        int robotDir = Integer.parseInt(st.nextToken());

        robot = new Robot(robotRow, robotCol, robotDir);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        simulation();
        System.out.print(cleanCount);
    }

    static void simulation() {
        while (true) {
            cleanNow(robot.row, robot.col);

            int rotateCount = 0;
            for (int i = 0; i < 4; i++) {
                if (rotateLeft()) {
                    break;
                } else {
                    rotateCount++;
                }
            }

            boolean back = true;
            if (rotateCount == 4) {
                back = goBack();
            }

            if (!back) {
                break;
            }
        }
    }

    static void cleanNow(int row, int col) {
        if (!visited[row][col]) {
            visited[row][col] = true;
            cleanCount++;
        }
    }

    static boolean rotateLeft() {
        int nextDir = robot.dir - 1;
        if (nextDir == -1) {
            nextDir = 3;
        }

        int nextRow = robot.row + dr[nextDir];
        int nextCol = robot.col + dc[nextDir];

        robot.dir = nextDir;

        if (nextRow >= 0 && nextCol >= 0 && nextRow < n && nextCol < m && !visited[nextRow][nextCol] && map[nextRow][nextCol] == 0) {
            robot.row = nextRow;
            robot.col = nextCol;

            return true;
        }
        return false;
    }

    static boolean goBack() {
        int nextDir = robot.dir + 2;
        if (nextDir > 3) {
            nextDir -= 4;
        }

        int nextRow = robot.row + dr[nextDir];
        int nextCol = robot.col + dc[nextDir];

        if (nextRow >= 0 && nextCol >= 0 && nextRow < n && nextCol < m && map[nextRow][nextCol] == 0) {
            robot.row = nextRow;
            robot.col = nextCol;

            return true;
        }

        return false;
    }
}
