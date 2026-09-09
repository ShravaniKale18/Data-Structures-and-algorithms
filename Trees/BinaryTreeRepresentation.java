package Trees;

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

public class BinaryTreeRepresentation{

    static void print(Node root) {
        if (root == null) {
            return;
        }

        System.out.println(root.data);
        print(root.left);
        print(root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(50);
        root.left.right = new Node(50);

        print(root);

    }
}