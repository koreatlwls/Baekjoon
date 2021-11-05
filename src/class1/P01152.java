package class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P01152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int count = 0;
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        while (stringTokenizer.hasMoreTokens()) {
            count++;
            stringTokenizer.nextToken();
        }
        System.out.println(count);
    }
}
