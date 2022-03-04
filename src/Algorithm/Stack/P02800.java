package Algorithm.Stack;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P02800 {

    static List<Point> list;
    static boolean[] selected;
    static Set<String> ans;
    static String input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();
        list = new ArrayList<>();

        input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stack.add(i);
            } else if (input.charAt(i) == ')') {
                int idx = stack.pop();
                list.add(new Point(idx, i));
            }
        }

        ans = new TreeSet<String>();
        selected = new boolean[list.size()];
        powerSet(0);
        for (String s : ans) {
            System.out.println(s);
        }
    }

    static void powerSet(int idx) {
        if (idx == selected.length) {
            StringBuilder sb = new StringBuilder();
            boolean check[] = new boolean[input.length()];
            for (int i = 0; i < selected.length; i++) {
                if (selected[i]) {
                    check[list.get(i).x] = true;
                    check[list.get(i).y] = true;
                }
            }

            for (int i = 0; i < input.length(); i++) {
                if (!check[i]) {
                    sb.append(input.charAt(i));
                }
            }
            if (sb.length() != input.length())
                ans.add(sb.toString());
            return;
        }
        selected[idx] = true;
        powerSet(idx + 1);
        selected[idx] = false;
        powerSet(idx + 1);
    }
}
