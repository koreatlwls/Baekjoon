package Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P20055 {

    static int n, k;
    static int[] durability;
    static boolean[] robot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        durability = new int[2 * n];
        robot = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < durability.length; i++) {
            durability[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(simulation(0));
    }

    static int simulation(int cnt) {
        while (isOK()) {
            int temp = durability[durability.length - 1];
            for (int i = durability.length-1; i > 0; i--) {
                durability[i] = durability[i - 1];
            }
            durability[0] = temp;

            for (int i = robot.length-1; i > 0; i--) {
                robot[i] = robot[i - 1];
            }
            robot[0] = false;
            robot[n - 1] = false;

            for (int i = n - 1; i > 0; i--) {
                if (robot[i - 1] && !robot[i] && durability[i] >= 1) {
                    robot[i] = true;
                    robot[i - 1] = false;
                    durability[i]--;
                }
            }

            if (durability[0] > 0) {
                robot[0] = true;
                durability[0]--;
            }

            cnt++;
        }

        return cnt;
    }

    static boolean isOK() {
        int cnt = 0;

        for (int i = 0; i < durability.length; i++) {
            if (durability[i] == 0) {
                cnt++;
            }

            if (cnt >= k) {
                return false;
            }
        }

        return true;
    }
}
