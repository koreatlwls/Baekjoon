package Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P02564 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        int totalLength = (N + M) * 2;

        for (int i = 0; i < S + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            int position = Integer.parseInt(st.nextToken());

            if (direction == 1) {
                list.add(position);
            } else if (direction == 2) {
                list.add(M + N + (M - position));
            } else if (direction == 3) {
                list.add(2 * M + N + (N - position));
            } else {
                list.add(M + position);
            }
        }

        int leng = list.get(list.size() - 1);
        int ans = 0;

        for(int i=0;i<S;i++){
            int tmp = Math.abs(list.get(i) - leng);
            ans += Math.min(tmp, totalLength - tmp);
        }

        System.out.print(ans);
    }
}
