package Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15787 {

    static int N, M;
    static int[] train;
    static int ans = 0;
    static boolean[] visited = new boolean[1<<21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        train = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = 0;
            int b = 0;
            switch (command) {
                case 1:
                    a = Integer.parseInt(st.nextToken());
                    b = Integer.parseInt(st.nextToken());
                    getOnTrain(a, b);
                    break;
                case 2:
                    a = Integer.parseInt(st.nextToken());
                    b = Integer.parseInt(st.nextToken());
                    getOffTrain(a, b);
                    break;
                case 3:
                    a = Integer.parseInt(st.nextToken());
                    goBack(a);
                    break;
                case 4:
                    a = Integer.parseInt(st.nextToken());
                    goFront(a);
                    break;
                default:
                    break;
            }
        }

        for (int i = 1; i <= N; i++) {
            if(!visited[train[i]]){
                ans++;
                visited[train[i]]= true;
            }
        }

        System.out.print(ans);
    }

    static void getOnTrain(int num, int seat) {
        train[num] |= (1 << seat);
    }

    static void getOffTrain(int num, int seat) {
        train[num] &= ~(1 << seat);
    }

    static void goBack(int num) {
        train[num] = train[num] << 1;
        train[num] = train[num] & ((1<<21)-1);
    }

    static void goFront(int num) {
        train[num] = train[num] >> 1;
        train[num] = train[num] & ~1;
    }
}
