package Algorithm.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P01253 {

    static int N;
    static HashMap<Integer, Integer> map = new HashMap<>();
    static int[] goods;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        goods = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            goods[i] = Integer.parseInt(st.nextToken());

            if (map.containsKey(goods[i])) {
                map.put(goods[i], map.get(goods[i]) + 1);
            } else {
                map.put(goods[i], 1);
            }
        }

        int sum;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {

                sum = goods[i] + goods[j];
                int add;

                if (map.containsKey(sum)) {
                    add = map.get(sum);

                    if (goods[i] == 0 && goods[j] == 0) {
                        if (add >= 3) {
                            answer += add;
                            map.remove(sum);
                        }
                    } else if (goods[i] == 0 || goods[j] == 0) {
                        if (add >= 2) {
                            answer += add;
                            map.remove(sum);
                        }
                    } else {
                        answer += add;
                        map.remove(sum);
                    }
                }
            }
        }

        System.out.print(answer);
    }
}
