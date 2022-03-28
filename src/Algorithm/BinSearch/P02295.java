package Algorithm.BinSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class P02295 {

    static int N;
    static int[] input;
    static ArrayList<Integer> sum = new ArrayList<>();
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        input = new int[N];

        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum.add(input[i] + input[j]);
            }
        }

        Arrays.sort(input);
        Collections.sort(sum);

        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if(binSearch(input[i] - input[j])> 0){
                    max = Math.max(max, input[i]);
                }
            }
        }

        System.out.print(max);
    }

    static int binSearch(int target) {
        int start = 0;
        int end = sum.size() -1 ;

        while (start < end) {
            int mid = (start + end) / 2;

            if (sum.get(mid) > target) {
                end = mid - 1;
            } else if (sum.get(mid) < target) {
                start = mid + 1;
            } else {
                return target;
            }
        }

        return 0;
    }
}
