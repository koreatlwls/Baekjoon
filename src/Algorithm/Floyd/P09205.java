package Algorithm.Floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P09205 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < n + 2; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list.add(new int[]{x, y});
            }

            boolean[][] flag = new boolean[n + 2][n + 2];
            for (int i = 0; i < n + 2; i++) {
                for (int j = 0; j < n + 2; j++) {
                    int[] pos = list.get(i), next = list.get(j);
                    int dis = Math.abs(pos[0] - next[0]) + Math.abs(pos[1] - next[1]);

                    if (dis <= 1000) flag[i][j] = true;
                }
            }

            for (int k = 0; k < n + 2; k++) {
                for (int i = 0; i < n + 2; i++) {
                    for (int j = 0; j < n + 2; j++) {
                        if (flag[i][k] && flag[k][j]) {
                            flag[i][j] = true;
                        }
                    }
                }
            }

            sb.append(flag[0][n + 1] ? "happy\n" : "sad\n");
        }
        System.out.print(sb);
    }
}
