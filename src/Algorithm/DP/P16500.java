package Algorithm.DP;

import java.util.Scanner;

public class P16500 {
    static String s;
    static int n;
    static String[] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        s = sc.nextLine();

        n = Integer.parseInt(sc.nextLine());
        a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLine();
        }

        boolean[] isPossibleWord = new boolean[s.length() + 1];
        isPossibleWord[0] = true;

        for (int i = 0; i < s.length(); i++) {
            int prefixLength = i + 1;

            for (int j = 0; j < n; j++) {
                if ((prefixLength >= a[j].length()) &&
                        s.substring(i - a[j].length() + 1, i + 1).equals(a[j])) {
                    if (isPossibleWord[prefixLength - a[j].length()]) {
                        isPossibleWord[prefixLength] = true;
                        break;
                    }
                }
            }
        }

        int result;
        if (isPossibleWord[s.length()]) result = 1;
        else result = 0;

        System.out.println(result);
    }
}
