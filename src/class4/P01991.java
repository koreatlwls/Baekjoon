package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P01991 {

    static int n;
    static StringBuilder sb = new StringBuilder();

    static class Node {
        char data;
        Node left;
        Node right;

        public Node(char data) {
            this.data = data;
        }
    }

    static class Tree{
        Node Root;

        public void Add(char Data,char Left_Data, char Right_Data){
            if(Root == null){
                if(Data!='.') Root = new Node(Data);
                if(Left_Data!='.') Root.left = new Node(Left_Data);
                if(Right_Data!='.')Root.right = new Node(Right_Data);
            }
            else Search(Root,Data,Left_Data,Right_Data);
        }

        public void Search(Node Root, char Data, char Left_Data, char Right_Data){
            if(Root == null) return;
            else if(Root.data == Data){
                if(Left_Data!='.')Root.left = new Node(Left_Data);
                if(Right_Data!='.')Root.right = new Node(Right_Data);
            }
            else {
                Search(Root.left, Data, Left_Data, Right_Data);
                Search(Root.right, Data, Left_Data, Right_Data);
            }
        }

        public void Preorder(Node Root){
            sb.append(Root.data);
            if(Root.left !=null)Preorder(Root.left);
            if(Root.right !=null)Preorder(Root.right);
        }

        public void Inorder(Node Root){
            if(Root.left !=null)Inorder(Root.left);
            sb.append(Root.data);
            if(Root.right !=null)Inorder(Root.right);
        }

        public void Postorder(Node Root){
            if(Root.left !=null)Postorder(Root.left);
            if(Root.right !=null)Postorder(Root.right);
            sb.append(Root.data);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        Tree tree = new Tree();
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            tree.Add(root,left,right);
        }

        tree.Preorder(tree.Root);
        sb.append("\n");
        tree.Inorder(tree.Root);
        sb.append("\n");
        tree.Postorder(tree.Root);
        sb.append("\n");

        System.out.print(sb);
    }
}
