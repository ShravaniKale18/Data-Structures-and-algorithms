class Node{
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class DiameterOfBinaryTree {
    static int diameter = 0;


    static int diameterOfBinaryTree(Node root) {

        diameter = 0;  
        maxDepth(root);
        
        return diameter;
    }

    static int maxDepth(Node root) {

        if (root == null) {
            return 0;
        }

        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);

        diameter = Math.max(diameter, lh + rh);

        return 1 + Math.max(lh, rh);
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println(diameterOfBinaryTree(root));
    }
}
