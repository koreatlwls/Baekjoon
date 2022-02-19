package Algorithm.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P02671 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String regex = "^(100+1+|01)+$";
        String sound = br.readLine();

        if(sound.matches(regex)){
            System.out.print("SUBMARINE");
        }else{
            System.out.print("NOISE");
        }
    }
}
