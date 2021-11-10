package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P02630 {

    static int[][] paper;
    static int whiteCount = 0;
    static int blueCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, 0, N);
        System.out.println(whiteCount);
        System.out.println(blueCount);
    }

    static void solve(int row, int col, int size) {
        if (check(row, col, size)) {
            if (paper[row][col] == 0) {
                whiteCount++;
            } else {
                blueCount++;
            }
            return;
        }

        int newSize = size / 2;

        solve(row, col, newSize);
        solve(row + newSize, col, newSize);
        solve(row, col + newSize, newSize);
        solve(row + newSize, col + newSize, newSize);
    }

    static boolean check(int row, int col, int size) {
        int color = paper[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (color != paper[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
