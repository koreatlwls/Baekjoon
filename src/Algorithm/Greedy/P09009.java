package Algorithm.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class P09009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-- >0){
            long num = Long.parseLong(br.readLine());

            for(long val : solution(num)){
                sb.append(val + " ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static ArrayList<Long> solution(long num){
        ArrayList<Long> fivo = new ArrayList<>();
        ArrayList<Long> answer = new ArrayList<>();
        fivo.add(0L);
        fivo.add(1L);
        int index = 2;

        while(true){
            long plusNum = fivo.get(index-1) + fivo.get(index-2);
            if(plusNum>num) break;
            fivo.add(plusNum);
            index++;
        }

        Collections.sort(fivo, Collections.reverseOrder());

        while (num != 0) {
            for(int i=0;i<fivo.size();i++){
                if(fivo.get(i) <= num){
                    num -= fivo.get(i);
                    answer.add(fivo.get(i));
                }
            }
        }

        Collections.sort(answer);
        answer.remove(0);
        return answer;
    }
}
