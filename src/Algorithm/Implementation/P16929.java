package Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P16929 {

    static int n,m,r;
    static int[][] input;
    static int group_value;
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        input = new int[n][m];
        group_value = Math.min(n,m) /2;

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<r;i++){
            solve();
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sb.append(input[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void solve(){
        for(int i=0;i<group_value;i++){
            int row = i;
            int col = i;

            int value = input[row][col];

            int idx = 0;
            while(idx<4){
                int nextRow = row +dr[idx];
                int nextCol = col +dc[idx];

                if(nextRow>=i&&nextCol>=i&&nextRow<n-i&&nextCol<m-i){
                    input[row][col] = input[nextRow][nextCol];
                    row = nextRow;
                    col = nextCol;
                }else{
                    idx++;
                }
            }

            input[i+1][i] = value;
        }
    }
}
