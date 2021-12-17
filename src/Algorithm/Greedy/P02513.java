package Algorithm.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P02513 {

    static int n, k, s;
    static PriorityQueue<Left> leftApart;
    static PriorityQueue<Right> rightApart;
    static int result = 0;

    static class Left implements Comparable<Left> {
        int point;
        int nums;

        public Left(int point, int nums) {
            this.point = point;
            this.nums = nums;
        }

        @Override
        public int compareTo(Left o) {
            return this.point - o.point;
        }
    }

    static class Right implements Comparable<Right> {
        int point;
        int nums;

        public Right(int point, int nums) {
            this.point = point;
            this.nums = nums;
        }

        @Override
        public int compareTo(Right o) {
            return o.point - this.point;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        leftApart = new PriorityQueue<>();
        rightApart = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a < s) {
                leftApart.add(new Left(a, b));
            } else {
                rightApart.add(new Right(a, b));
            }
        }

        int bus = k;
        int maxDist = Integer.MIN_VALUE;
        while (!leftApart.isEmpty()) {
            maxDist = Math.max(maxDist, s - leftApart.peek().point);
            while (true) {
                if (bus == 0 || leftApart.peek().nums == 0) {
                    break;
                }
                bus--;
                leftApart.peek().nums--;
            }
            if (leftApart.peek().nums == 0) {
                leftApart.poll();
            }
            if (bus == 0 || leftApart.isEmpty()) {
                result += maxDist * 2;
                maxDist = 0;
                bus = k;
            }
        }

        bus = k;
        maxDist = Integer.MIN_VALUE;
        while (!rightApart.isEmpty()) {
            maxDist = Math.max(maxDist, rightApart.peek().point - s);
            while (true) {
                if (bus == 0 || rightApart.peek().nums == 0) {
                    break;
                }
                bus--;
                rightApart.peek().nums--;
            }
            if (rightApart.peek().nums == 0) {
                rightApart.poll();
            }
            if (bus == 0 || rightApart.isEmpty()) {
                result += maxDist * 2;
                maxDist = 0;
                bus = k;
            }

        }

        System.out.print(result);
    }
}
