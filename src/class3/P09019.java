package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P09019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            boolean[] visit = new boolean[10000];
            visit[A] = true;

            Queue<Register> que = new LinkedList<>();
            que.add(new Register(A, ""));

            String ans = "";
            while (!que.isEmpty()) {
                Register cur = que.poll();

                if (cur.num == B) {
                    sb.append(cur.command).append("\n");
                    break;
                }

                if (!visit[cur.D()]) {
                    que.add(new Register(cur.D(), cur.command + "D"));
                    visit[cur.D()] = true;
                }
                if (!visit[cur.S()]) {
                    que.add(new Register(cur.S(), cur.command + "S"));
                    visit[cur.S()] = true;
                }
                if (!visit[cur.L()]) {
                    que.add(new Register(cur.L(), cur.command + "L"));
                    visit[cur.L()] = true;
                }
                if (!visit[cur.R()]) {
                    que.add(new Register(cur.R(), cur.command + "R"));
                    visit[cur.R()] = true;
                }

            }
        }
        System.out.print(sb);
    }

    static class Register {
        int num;
        String command;

        Register(int num, String command) {
            this.num = num;
            this.command = command;
        }

        int D() {
            return (num * 2) % 10000;
        }

        int S() {
            return num == 0 ? 9999 : num - 1;
        }

        int L() {
            return num % 1000 * 10 + num / 1000;
        }

        int R() {
            return num % 10 * 1000 + num / 10;
        }
    }
}
