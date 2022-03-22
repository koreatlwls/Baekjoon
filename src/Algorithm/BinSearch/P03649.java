package Algorithm.BinSearch;

import java.util.Arrays;
import java.util.Scanner;

public class P03649{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            long x = sc.nextInt() * 10000000;
            int n = sc.nextInt();
            int[] legoArr = new int[n];

            for (int i = 0; i < n; i++) {
                legoArr[i] = sc.nextInt();
            }

            Arrays.sort(legoArr);

            int left = 0, right = legoArr.length - 1;

            while (left < right) {
                long sum = legoArr[left] + legoArr[right];

                if (sum == x) {
                    break;
                }

                if (sum < x) {
                    left++;
                } else {
                    right--;
                }
            }

            if(left >= right){
                System.out.println("danger");
            }else{
                System.out.println(String.format("yes %d %d",legoArr[left],legoArr[right]));;
            }
        }
    }
}
