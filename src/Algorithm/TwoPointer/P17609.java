package Algorithm.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P17609 {

    static char[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-- >0){
            String input = br.readLine();
            arr = input.toCharArray();

            int left = 0;
            int right = arr.length - 1;

            if(check(left,right)){
                sb.append(0).append("\n");
                continue;
            }
            if(checkS(left,right)){
                sb.append(1).append("\n");
            }else{
                sb.append(2).append("\n");
            }
        }

        System.out.print(sb);
    }

    static boolean check(int left, int right){
        while(left <= right) {
            if(arr[left] != arr[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    static boolean checkS(int left, int right){
        while(left <= right){
            if(arr[left] != arr[right]){
                boolean a = check(left+1, right);
                boolean b = check(left, right-1);
                if(!a && !b){
                    return false;
                }else{
                    return true;
                }
            }

            left++;
            right--;
        }

        return true;
    }
}
