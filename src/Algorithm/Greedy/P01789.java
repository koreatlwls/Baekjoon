package Algorithm.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long S = Long.parseLong(br.readLine());

        System.out.print(solve(S));
    }

    static int solve(long n) {
        long sum = 0;
        int addNum = 0;
        while (n >= sum) {
            sum += (++addNum);
        }

        return sum == n ? addNum : addNum - 1;
    }
}
