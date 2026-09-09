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

public class DFSTraversal {

    static void inOrderTraversal(Node head){
        if (head == null) {
            return;
        }

        inOrderTraversal(head.left);
        System.out.print(head.data+" ");
        inOrderTraversal(head.right);
    }

    static void preOrderTraversal(Node head){
        if (head == null) {
            return;
        }

        System.out.print(head.data+" ");
        preOrderTraversal(head.left);
        preOrderTraversal(head.right);
    }

    static void postOrderTraversal(Node head){
        if (head == null) {
            return;
        }

        postOrderTraversal(head.left);
        postOrderTraversal(head.right);
        System.out.print(head.data+" ");
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(50);
        root.left.right = new Node(100);

        System.out.println("In Order Traversal : ");
        inOrderTraversal(root);
        System.out.println("\nPreOrder Traversal : ");
        preOrderTraversal(root);
        System.out.println("\nPostOrder Traversal : ");
        postOrderTraversal(root);
    }
}
