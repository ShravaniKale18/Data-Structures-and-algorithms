import java.util.*;

class Node{
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class IterativePreOrderTraversal {

    static void iterativePreorderTraversal(Node root) {
        if(root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();

        stack.push(root);

        while(!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.print(current.data + " ");

           
            if(current.right != null) {
                stack.push(current.right);
            }

            if(current.left != null) {
                stack.push(current.left);
            }
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(10);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Iterative Preorder traversal of binary tree is:");
        iterativePreorderTraversal(root);
    }
}
