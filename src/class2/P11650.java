package class2;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int i;
        ArrayList<Point> list = new ArrayList<>();

        for (i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            Point point = new Point();
            point.x = Integer.parseInt(stringTokenizer.nextToken());
            point.y = Integer.parseInt(stringTokenizer.nextToken());
            list.add(point);
        }

        Collections.sort(list, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.x > o2.x) {
                    return 1;
                } else if (o1.x == o2.x) {
                    if (o1.y > o2.y) {
                        return 1;
                    } else if (o1.y == o2.y) {
                        return 0;
                    } else {
                        return -1;
                    }
                } else {
                    return -1;
                }
            }
        });

        for (Point result : list) {
            sb.append(result.x).append(" ").append(result.y).append("\n");
        }
        System.out.print(sb);
    }
}
