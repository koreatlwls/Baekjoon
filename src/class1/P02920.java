package class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P02920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int i;
        int[] arr = new int[8];
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        for (i = 0; i < 8; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        if (arr[0] == 1 && arr[1] == 2 && arr[2] == 3 && arr[3] == 4 && arr[4] == 5 && arr[5] == 6 && arr[6] == 7 && arr[7] == 8)
            System.out.print("ascending");
        else if (arr[0] == 8 && arr[1] == 7 && arr[2] == 6 && arr[3] == 5 && arr[4] == 4 && arr[5] == 3 && arr[6] == 2 && arr[7] == 1)
            System.out.print("descending");
        else
            System.out.print("mixed");
    }
}
