package Algorithm.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class P13904 {

    static class Assignment {
        int day;
        int weight;

        public Assignment(int day, int weight) {
            this.day = day;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        List<Assignment> list = new ArrayList<>();
        int maxDay = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.add(new Assignment(d, w));
            maxDay = Math.max(maxDay, d);
        }

        int totalScore = 0;
        for (int i = maxDay; i > 0; i--) {
            totalScore += getMax(list, i);
        }

        System.out.print(totalScore);
    }

    static int getMax(List<Assignment> list, int now) {
        int idx = -1;
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).day >= now && result < list.get(i).weight) {
                idx = i;
                result = list.get(i).weight;
            }
        }

        if (result == 0) {
            return 0;
        }

        list.remove(idx);
        return result;
    }
}
