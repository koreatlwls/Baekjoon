package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        int count = 1;
        int numOfDeath = 666;

        while (count < num) {
            numOfDeath++;
            if (String.valueOf(numOfDeath).contains("666")) {
                count++;
            }
        }
        System.out.print(numOfDeath);
    }
}