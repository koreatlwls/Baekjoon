package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P02231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        int check = 0;
        int add = 0;
        boolean find = false;

        for (int i = 1; i < num; i++) {
            add = i;
            check += add;
            while (add != 0) {
                check += add % 10;
                add /= 10;
            }
            if (check == num) {
                System.out.print(i);
                find = true;
                break;
            }
            check = 0;
        }
        if (!find)
            System.out.print("0");
    }
}
