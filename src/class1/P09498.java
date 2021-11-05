package class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P09498 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int score = Integer.parseInt(br.readLine());

        if (score <= 100 && score >= 90)
            System.out.print("A");
        else if (score <= 89 && score >= 80)
            System.out.print("B");
        else if (score <= 79 && score >= 70)
            System.out.print("C");
        else if (score <= 69 && score >= 60)
            System.out.print("D");
        else
            System.out.print("F");
    }
}
