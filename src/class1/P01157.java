package class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class P01157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        String lowStr = str.toLowerCase(Locale.ROOT);
        countChar(lowStr);
    }

    public static void countChar(String str) {
        int i;
        int max = 0;
        int overlapCount = 0;
        int charPosition = 0;
        char result;
        int[] arr = new int[26];

        for (i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 97]++;
        }
        for (i = 0; i < 26; i++) {
            if (max < arr[i])
                max = arr[i];
        }
        for (i = 0; i < 26; i++) {
            if (max == arr[i]) {
                charPosition = i;
                overlapCount++;
            }
        }
        result = (char) (65 + charPosition);
        if (overlapCount > 1)
            System.out.println("?");
        else
            System.out.println(result);
    }
}
