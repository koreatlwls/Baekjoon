package Algorithm.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P01374 {

    static class Lesson implements Comparable<Lesson> {
        int start;
        int end;

        public Lesson(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Lesson o) {
            if (this.start == o.start) {
                return this.end - o.end;
            }
            return this.start - o.start;
        }
    }

    static int N;
    static Lesson[] lessons;
    static PriorityQueue<Lesson> pq = new PriorityQueue<>((l1, l2) -> {
        int endDiff = l1.end - l2.end;
        if (endDiff != 0) {
            return endDiff;
        } else {
            return l1.start - l2.start;
        }
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        lessons = new Lesson[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            lessons[i] = new Lesson(start, end);
        }

        Arrays.sort(lessons);

        System.out.print(solution());
    }

    static int solution() {
        pq.add(lessons[0]);
        int minNum = 1;

        if (lessons.length == 1)
            return minNum;

        for (int i = 1; i < lessons.length; i++) {
            if (!pq.isEmpty()) {
                Lesson currentLesson = pq.peek();

                if (currentLesson.end <= lessons[i].start) {
                    pq.remove();
                    pq.add(lessons[i]);
                } else {
                    pq.add(lessons[i]);
                    minNum++;
                }
            } else {
                pq.add(lessons[i]);
            }
        }

        return minNum;
    }
}
