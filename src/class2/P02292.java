package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P02292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int layer = 1;
        int num = 0;
        int totalNum = 1;

        while (true) {
            if (n <= totalNum)
                break;
            else {
                num += 6;
                totalNum += num;
                layer++;
            }
        }
        System.out.print(layer);
    }
}
