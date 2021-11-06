package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class P10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        int[] nInput = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int value1 : nInput) {
            if (hashMap.containsKey(value1)) {
                hashMap.put(value1, hashMap.get(value1) + 1);
            } else {
                hashMap.put(value1, 1);
            }
        }

        int M = Integer.parseInt(br.readLine());
        int[] mInput = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] result = new int[M];

        for (int i = 0; i < M; i++) {
            if (hashMap.containsKey(mInput[i])) {
                result[i] = hashMap.get(mInput[i]);
            } else {
                result[i] = 0;
            }
            sb.append(result[i]).append(" ");
        }
        System.out.print(sb);
    }
}
