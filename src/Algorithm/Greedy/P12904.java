package Algorithm.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P12904 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer S = new StringBuffer(br.readLine());
        StringBuffer T = new StringBuffer(br.readLine());


        while(S.length()<T.length()){
            if(T.charAt(T.length()-1)== 'A'){
                T.deleteCharAt(T.length()-1);
            }else{
                T.deleteCharAt(T.length()-1);
                T.reverse();
            }
        }

        if(S.toString().equals(T.toString())){
            System.out.print(1);
        }else{
            System.out.print(0);
        }
    }
}
