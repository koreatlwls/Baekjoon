package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P04153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tri[] = new int[3];
        StringTokenizer stringTokenizer;
        while (true) {
            stringTokenizer = new StringTokenizer(br.readLine());
            for (int i = 0; i < 3; i++) {
                tri[i] = Integer.parseInt(stringTokenizer.nextToken());
            }
            Arrays.sort(tri);
            if (tri[2] == 0)
                break;
            if (Math.pow(tri[2], 2) == Math.pow(tri[0], 2) + Math.pow(tri[1], 2))
                sb.append("right\n");
            else
                sb.append("wrong\n");
        }
        System.out.print(sb);
    }
}
