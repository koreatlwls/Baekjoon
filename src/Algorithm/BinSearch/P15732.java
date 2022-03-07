package Algorithm.BinSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P15732 {

    static class Box {
        int start;
        int end;
        int unit;

        public Box(int start, int end, int unit) {
            this.start = start;
            this.end = end;
            this.unit = unit;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        ArrayList<Box> box = new ArrayList<Box>();

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            box.add(new Box(a, b, c));
        }

        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = (left + right) / 2;
            long cnt = 0;
            for (int i = 0; i < box.size(); i++) {
                if (box.get(i).end <= mid)
                    cnt += (box.get(i).end - box.get(i).start) / box.get(i).unit + 1;
                else if (box.get(i).start > mid) continue;
                else
                    cnt += (mid - box.get(i).start) == 0 ? 1 : (mid - box.get(i).start) / box.get(i).unit + 1;
            }
            if (cnt >= d) right = mid - 1;
            else left = mid + 1;
        }
        System.out.println(left);
    }
}