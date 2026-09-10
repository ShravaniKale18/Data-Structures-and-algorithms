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

public class IterativeInOrderTraversal {

    static ArrayList<Integer> inOrderTraversal(Node root) {

        ArrayList<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (!stack.isEmpty() || current != null) {

            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            list.add(current.data);

            current = current.right;
        }

        return list;
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(50);
        root.left.right = new Node(100);

        System.out.println(inOrderTraversal(root));
    }
}
