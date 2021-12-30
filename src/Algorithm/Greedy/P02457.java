package Algorithm.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P02457 {

    static int n;
    static int[] monthArr = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static ArrayList<Flower> flowerList = new ArrayList<>();
    static int likeFlowerStartDay, likeFlowerEndDay;

    static class Flower implements Comparable<Flower>{
        int start;
        int end;

        public Flower(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Flower o){
            if(this.start == o.start){
                return this.end-o.end;
            }
            return this.start - o.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            flowerList.add(new Flower(dayCount(a, b), dayCount(c, d)));
        }

        Collections.sort(flowerList);

        likeFlowerStartDay = dayCount(3, 1);  // 이하여야함
        likeFlowerEndDay = dayCount(11, 30);  // 초과여야함

        int ans = 0;
        int start = likeFlowerStartDay;
        int max = 0;
        int idx = 0;

        while (start <= likeFlowerEndDay) {
            max = 0;
            boolean flag = false;

            for (int i = idx; i < n; i++) {
                Flower now = flowerList.get(i);
                if (now.start > start) break;
                if (now.start <= start && max < now.end) {
                    max = now.end;
                    idx = i + 1;
                    flag = true;
                }
            }

            if (flag) {
                start = max;
                ans++;
            } else {
                break;
            }
        }

        System.out.print((max <= likeFlowerEndDay) ? 0 : ans);
    }

    static int dayCount(int month, int day) {
        int sum = 0;

        for (int i = 1; i < month; i++) {
            sum += monthArr[i];
        }

        sum += day;

        return sum;
    }
}
