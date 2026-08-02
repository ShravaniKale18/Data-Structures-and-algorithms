import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

public class IterativePostOrder {

    static void postOrder(Node root) {

        if (root == null)
            return;

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(root);

        while (!s1.isEmpty()) {

            Node curr = s1.pop();
            s2.push(curr);

            if (curr.left != null)
                s1.push(curr.left);

            if (curr.right != null)
                s1.push(curr.right);
        }

        while (!s2.isEmpty()) {
            System.out.print(s2.pop().data + " ");
        }
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(10);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        postOrder(root);
    }
}