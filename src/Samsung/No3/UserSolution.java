package Samsung.No3;

class UserSolution {
    static boolean[][] visited;

    static int hit;
    static int MAX_HIT;

    static int[] cnt;

    static Solution solution;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public void init(int limit) {
        cnt = new int[]{5, 4, 3, 3, 2};

        solution = new Solution();

        visited = new boolean[10][10];

        hit = 0;

        MAX_HIT = 17;
    }

    public void play() {
        init(0);

        for (int i = 0; i < 10; i++) {
            for (int j = i % 2; j < 10; j += 2) {
                if (visited[i][j]) {
                    continue;
                }

                visited[i][j] = true;
                int ret = solution.fire(i, j);
                if (ret > 0 && ret < 6) {
                    hit++;
                    cnt[ret - 1]--;
                    dfs(i, j, ret, -1);
                }

                if (hit == MAX_HIT) {
                    return;
                }

            }
        }
    }

    static void dfs(int row, int col, int type, int dir) {
        if(cnt[type-1]==0){
            return;
        }

        int nextRow = 0;
        int nextCol = 0;
        int ret = 0;

        if (dir == -1) {
            for (int i = 0; i < 4; i++) {
                nextRow = row + dr[i];
                nextCol = col + dc[i];

                if (nextRow >= 0 && nextRow < 10 && nextCol >= 0 && nextCol < 10 && !visited[nextRow][nextCol]) {
                    visited[nextRow][nextCol] = true;
                    ret = solution.fire(nextRow, nextCol);

                    if (ret == type) {
                        hit++;
                        cnt[ret - 1]--;
                        dfs(nextRow, nextCol, ret, i);
                    }
                }
            }
        } else {
            nextRow = row + dr[dir];
            nextCol = col + dc[dir];

            if (nextRow >= 0 && nextRow < 10 && nextCol >= 0 && nextCol < 10 && !visited[nextRow][nextCol]) {
                visited[nextRow][nextCol] = true;
                ret = solution.fire(nextRow, nextCol);

                if (ret == type) {
                    hit++;
                    cnt[ret - 1]--;
                    dfs(nextRow, nextCol, ret, dir);
                }
            }
        }
    }
}