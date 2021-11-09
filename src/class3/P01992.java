package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01992 {

    static StringBuilder sb = new StringBuilder();
    static int input[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        input = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                input[i][j] = str.charAt(j) - '0';
            }
        }

        partition(0, 0, N);
        System.out.print(sb);
    }

    public static void partition(int row, int col, int size) {
        if (check(row, col, size)) {
            sb.append(input[row][col]);
            return;
        }

        int newSize = size / 2;

        sb.append("(");
        partition(row, col, newSize);
        partition(row, col + newSize, newSize);
        partition(row + newSize, col, newSize);
        partition(row + newSize, col + newSize, newSize);
        sb.append(")");
    }

    public static boolean check(int row, int col, int size) {
        int color = input[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (color != input[i][j])
                    return false;
            }
        }
        return true;
    }
}
