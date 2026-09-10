package Trees;

import java.util.ArrayList;
import java.util.Stack;

class Node{
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class IterativePostOrderTraversal {

    static ArrayList<Integer> postOrderTraversal(Node root) {

        Stack<Node> stack1 = new Stack<>();       
        Stack<Node> stack2 = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        stack1.push(root);
        while (!stack1.isEmpty()) {

            root = stack1.pop();
            stack2.push(root);

            if (root.left != null) {
                stack1.push(root.left);
            }

            if (root.right != null) {
                stack1.push(root.right);
            }
        }

        while (!stack2.isEmpty()) {
            list.add(stack2.pop().data);
        }

        return list;
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(50);
        root.left.right = new Node(100);

        System.out.println(postOrderTraversal(root));
    }
}