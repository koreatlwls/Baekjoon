package Algorithm.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P03109 {

    static int r,c;
    static int val;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        for(int i=0;i<r;i++){
            map[i] = br.readLine().toCharArray();
        }

        for(int i=0;i<r;i++){
            if(check(i,0))val++;
        }

        System.out.print(val);
    }

    static boolean check(int x,int y){
        map[x][y] = '-';

        if(y == c-1){
            return true;
        }

        if(x>0 && map[x-1][y+1] == '.'){
            if(check(x-1,y+1))return true;
        }

        if(map[x][y+1] == '.'){
            if(check(x,y+1))return true;
        }

        if(x+1 <r && map[x+1][y+1] == '.'){
            if(check(x+1,y+1))return true;
        }

        return false;
    }
}
