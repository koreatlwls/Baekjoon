package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P01764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int i, j;

        HashSet<String> hashSet = new HashSet<>();
        for (i = 0; i < N; i++) {
            hashSet.add(br.readLine());
        }

        ArrayList<String> answer = new ArrayList<>();
        for (j = 0; j < M; j++) {
            String str = br.readLine();
            if (hashSet.contains(str)) {
                answer.add(str);
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        for (String str : answer) {
            System.out.println(str);
        }
    }
}
