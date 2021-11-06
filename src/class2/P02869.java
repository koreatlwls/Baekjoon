package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P02869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(stringTokenizer.nextToken());
        int B = Integer.parseInt(stringTokenizer.nextToken());
        int V = Integer.parseInt(stringTokenizer.nextToken());
        int day = (V - B) / (A - B);

        if ((V - B) % (A - B) != 0)
            day++;

        System.out.print(day);
    }
}
