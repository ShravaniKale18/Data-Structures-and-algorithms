import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class IterativeInorder {

    static void iterativeInorderTraversal(Node root) {
        if(root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        Node current = root;

        while(current != null || !stack.isEmpty()) {
            if(current != null) {
                stack.push(current);
                current = current.left;
            }else{
                current = stack.pop();
                System.out.print(current.data + " ");
                current = current.right;
            }
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(10);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Iterative Inorder traversal of binary tree is:");
        iterativeInorderTraversal(root);
    }
}
