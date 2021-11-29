package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P02263 {

    static int n;
    static int[] in, post, pre;
    static int idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        in = new int[n];
        post = new int[n];
        pre = new int[n];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            in[i] = Integer.parseInt(input[i]);

        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            post[i] = Integer.parseInt(input[i]);

        getPreOrder(0, n - 1, 0, n - 1);

        for (int i = 0; i < n; i++) {
            System.out.print(pre[i] + " ");
        }
    }

    static void getPreOrder(int is, int ie, int ps, int pe) {
        if (is <= ie && ps <= pe) {
            pre[idx++] = post[pe];

            int pos = is;
            for (int i = is; i <= ie; i++) {
                if (in[i] == post[pe]) {
                    pos = i;
                    break;
                }
            }

            getPreOrder(is, pos - 1, ps, ps + pos - is - 1);
            getPreOrder(pos + 1, ie, ps + pos - is, pe - 1);
        }
    }
}
