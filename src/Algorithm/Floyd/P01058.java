package Algorithm.Floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01058 {

    static int N;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                if (input.charAt(j) == 'Y') {
                    map[i][j] = 1;
                } else {
                    map[i][j] = 987654321;
                }
            }
        }

        for(int k=0;k<N;k++){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(i==j || j==k || i==k)continue;

                    if(map[i][j] > map[i][k] + map[k][j]){
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            int count = 0;
            for(int j=0;j<N;j++){
                if(i==j)continue;

                if(map[i][j] <=2){
                    count++;
                }
            }

            max = Math.max(max, count);
        }

        System.out.print(max);
    }
}
