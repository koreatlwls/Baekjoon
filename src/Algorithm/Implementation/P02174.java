package Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P02174 {

    static class Robot {
        int num;
        int x;
        int y;
        int dir;

        public Robot(int num, int x, int y, int dir) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    static int A, B, N, M;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static ArrayList<Robot> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        map = new int[B][A];

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int num = 0;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            String dir = st.nextToken();

            map[B - y - 1][x] = i;
            if (dir.equals("N")) num = 0;
            else if (dir.equals("E")) num = 1;
            else if (dir.equals("S")) num = 2;
            else if (dir.equals("W")) num = 3;

            list.add(new Robot(i, B - y - 1, x, num));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int robot = Integer.parseInt(st.nextToken());
            String command = st.nextToken();
            int repetition = Integer.parseInt(st.nextToken());
            move(robot, command, repetition);
        }

        System.out.println("OK");

    }

    static void move(int robot, String command, int repetition) {

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).num == robot) {
                int direction = list.get(i).dir;

                if (command.equals("L")) {
                    for (int j = 0; j < repetition; j++) {
                        if (direction == 0) direction = 3;
                        else direction--;
                    }
                    list.set(i, new Robot(list.get(i).num, list.get(i).x, list.get(i).y, direction));
                } else if (command.equals("R")) {
                    for (int j = 0; j < repetition; j++) {
                        if (direction == 3) direction = 0;
                        else direction++;
                    }
                    list.set(i, new Robot(list.get(i).num, list.get(i).x, list.get(i).y, direction));
                } else if (command.equals("F")) {
                    int x = list.get(i).x;
                    int y = list.get(i).y;
                    map[x][y] = 0;
                    int nx = 0, ny = 0;
                    for (int j = 0; j < repetition; j++) {
                        nx = x + dx[direction];
                        ny = y + dy[direction];

                        if (range(nx, ny)) {
                            if (map[nx][ny] == 0) {
                                x = nx;
                                y = ny;
                            } else {
                                System.out.println("Robot " + list.get(i).num + " crashes into robot " + map[nx][ny]);
                                System.exit(0);
                            }
                        } else {
                            System.out.println("Robot " + list.get(i).num + " crashes into the wall");
                            System.exit(0);
                        }
                    }
                    map[nx][ny] = list.get(i).num;
                    list.set(i, new Robot(list.get(i).num, nx, ny, direction));
                }
            }
        }

    }

    static boolean range(int x, int y) {
        return x >= 0 && x < B && y >= 0 && y < A;
    }

}
