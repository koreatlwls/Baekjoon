package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P05639 {

    static class Node {
        int num;
        Node Left, Right;

        Node(int num) {
            this.num = num;
        }

        Node(int num, Node Left, Node Right) {
            this.num = num;
            this.Left = Left;
            this.Right = Right;
        }

        void insert(int n) {
            if (n < this.num) {
                if (this.Left == null) {
                    this.Left = new Node(n);
                } else {
                    this.Left.insert(n);
                }
            } else {
                if (this.Right == null) {
                    this.Right = new Node(n);
                } else {
                    this.Right.insert(n);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Node root = new Node(Integer.parseInt(br.readLine()));
        String input;
        while (true) {
            input = br.readLine();
            if (input == null || input.equals("")) break;

            root.insert(Integer.parseInt(input));
        }

        postOrder(root);
    }

    static void postOrder(Node node) {
        if (node == null) return;

        postOrder(node.Left);
        postOrder(node.Right);
        System.out.println(node.num);
    }
}
