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

public class TreeCreation {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Root: " + root.data);
        System.out.println("Root Left: " + root.left.data);
        System.out.println("Root Right: " + root.right.data);
        System.out.println("Root Left Left: " + root.left.left.data);
        System.out.println("Root Left Right: " + root.left.right.data);
    }
}
