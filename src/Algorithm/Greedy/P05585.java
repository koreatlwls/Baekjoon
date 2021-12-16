package Algorithm.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P05585 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int cost = Integer.parseInt(br.readLine());
        int change = 1000 - cost;
        int result = 0;

        int[] coins = {500, 100, 50, 10, 5, 1};

        for (int coin : coins) {

            if (coin > change)
                continue;
            result += change / coin;
            change %= coin;

        }
        System.out.println(result);
    }
}
