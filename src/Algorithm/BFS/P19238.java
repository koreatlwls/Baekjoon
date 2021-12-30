package Algorithm.BFS;

import java.io.*;
import java.util.*;

public class P19238 {
    static int N, M, fuel;
    static int[][] map;
    static boolean[][] visited;
    static int joon_x, joon_y;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static ArrayList<Node> startList = new ArrayList<>();
    static ArrayList<Path> pathList = new ArrayList<>();

    static class Node implements Comparable<Node> {
        int x, y, dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            if (this.dist != o.dist) {
                return this.dist - o.dist;
            } else {
                if (this.x != o.x) {
                    return this.x - o.x;
                } else {
                    return this.y - o.y;
                }
            }
        }
    }

    static class Path {
        int start_x, start_y, end_x, end_y;

        public Path(int start_x, int start_y, int end_x, int end_y) {
            this.start_x = start_x;
            this.start_y = start_y;
            this.end_x = end_x;
            this.end_y = end_y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    map[i][j] = -1;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        joon_x = Integer.parseInt(st.nextToken());
        joon_y = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int start_x = Integer.parseInt(st.nextToken());
            int start_y = Integer.parseInt(st.nextToken());
            int end_x = Integer.parseInt(st.nextToken());
            int end_y = Integer.parseInt(st.nextToken());
            pathList.add(new Path(start_x, start_y, end_x, end_y));
            map[start_x][start_y] = i;
        }

        while (true) {
            if (pathList.size() == 0) {
                System.out.println(fuel);
                return;
            }

            startList.clear();
            visited = new boolean[N + 1][N + 1];

            getStart(joon_x, joon_y);

            if (startList.size() == 0) {
                System.out.println(-1);
                return;
            }

            Node start = startList.get(0);
            map[start.x][start.y] = 0;
            fuel -= start.dist;

            if (fuel < 0) {
                System.out.println(-1);
                return;
            }

            visited = new boolean[N + 1][N + 1];

            int dist = 0;
            for (int i = 0; i < pathList.size(); i++) {
                Path path = pathList.get(i);

                if (path.start_x == start.x && path.start_y == start.y) {
                    dist = getDist(path.start_x, path.start_y, path.end_x, path.end_y);

                    if (dist == -1) {
                        System.out.println(-1);
                        return;
                    }
                    joon_x = path.end_x;
                    joon_y = path.end_y;
                    pathList.remove(path);
                    break;
                }
            }

            fuel -= dist;

            if (fuel < 0) {
                System.out.println(-1);
                return;
            }

            fuel += dist * 2;
        }

    }

    static void getStart(int x, int y) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(x, y, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (map[cur.x][cur.y] >= 1) {
                startList.add(new Node(cur.x, cur.y, cur.dist));
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx > 0 && nx <= N && ny > 0 && ny <= N) {
                    if (map[nx][ny] != -1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new Node(nx, ny, cur.dist + 1));
                    }
                }
            }
        }
    }

    static int getDist(int start_x, int start_y, int end_x, int end_y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start_x, start_y, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.x == end_x && cur.y == end_y) {
                return cur.dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx > 0 && nx <= N && ny > 0 && ny <= N) {
                    if (map[nx][ny] != -1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new Node(nx, ny, cur.dist + 1));
                    }
                }
            }
        }
        return -1;
    }
}