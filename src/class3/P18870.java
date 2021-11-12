package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P18870 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int[] temp = arr.clone();
        Arrays.sort(arr);

        HashMap<Integer, Integer> hmap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!hmap.containsKey(arr[i]))
                hmap.put(arr[i], cnt++);
        }

        for (int i = 0; i < N; i++) {
            sb.append(hmap.get(temp[i])).append(" ");
        }

        System.out.print(sb);
    }
}
