package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P01620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        HashMap<String, Integer> hashMap = new HashMap<>();
        String[] nameArr = new String[N + 1];

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            hashMap.put(name, i);
            nameArr[i] = name;
        }

        for (int i = 0; i < M; i++) {
            String problem = br.readLine();
            if (isStringNumber(problem)) {
                int index = Integer.parseInt(problem);
                sb.append(nameArr[index]);
            } else {
                sb.append(hashMap.get(problem));
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static boolean isStringNumber(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
