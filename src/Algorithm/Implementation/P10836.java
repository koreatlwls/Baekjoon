package Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P10836 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] size = new int[m][m];

        for(int i = 0; i < m; i++) {
            Arrays.fill(size[i], 1);
        }

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int zero = Integer.parseInt(st.nextToken());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());

            for(int j = m-1; j >= 0; j--) {
                if(zero != 0) {
                    zero--;
                } else if(one != 0) {
                    one--;
                    size[j][0] += 1;
                } else if(two != 0) {
                    two--;
                    size[j][0] += 2;
                }
            }

            for(int j = 1; j < m; j++) {
                if(zero != 0) {
                    zero--;
                } else if(one != 0) {
                    one--;
                    size[0][j] += 1;
                } else if(two != 0) {
                    two--;
                    size[0][j] += 2;
                }
            }
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < m; j++) {
                size[i][j] = size[i - 1][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(size[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}