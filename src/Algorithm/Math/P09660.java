package Algorithm.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P09660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Long n = Long.parseLong(br.readLine());

        if(n%7==0 || n%7 ==2){
            System.out.print("CY");
        }else{
            System.out.print("SK");
        }
    }
}
