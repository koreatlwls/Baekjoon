package class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int i;
        String input = br.readLine();
        int[] result = new int[26];
        Arrays.fill(result, -1);

        for (i = 0; i < input.length(); i++) {
            if (result[input.charAt(i) - 97] == -1)
                result[input.charAt(i) - 97] = i;
        }
        for (i = 0; i < result.length; i++) {
            System.out.printf("%d ", result[i]);
        }
    }
}
