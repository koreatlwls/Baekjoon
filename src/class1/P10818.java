package class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int max = -1000001;
        int min = 1000001;
        int num = Integer.parseInt(br.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int result;

        for (int i = 0; i < num; i++) {
            result = Integer.parseInt(stringTokenizer.nextToken());
            if (max < result)
                max = result;
            if (min > result)
                min = result;
        }
        System.out.printf("%d %d", min, max);
    }
}
