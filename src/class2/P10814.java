package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String input[][] = new String[N][2];
        int i;

        for (i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            input[i][0] = stringTokenizer.nextToken();
            input[i][1] = stringTokenizer.nextToken();
        }

        Arrays.sort(input, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if (Integer.parseInt(o1[0]) > Integer.parseInt(o2[0])) {
                    return 1;
                } else if (Integer.parseInt(o1[0]) < Integer.parseInt(o2[0])) {
                    return -1;
                }
                return 0;
            }
        });

        for(i=0;i<N;i++){
            sb.append(input[i][0]).append(" ").append(input[i][1]).append("\n");
        }
        System.out.print(sb);
    }
}
