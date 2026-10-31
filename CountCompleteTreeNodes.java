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

public class CountCompleteTreeNodes {

    public static int countNodes(Node root) {

        int leftSubTreeHeight = heightOfLeftSubtree(root);
        int rightSubTreeHeight = heightOfRightSubtree(root);

        if (leftSubTreeHeight == rightSubTreeHeight) {
            return (1 << leftSubTreeHeight) - 1; // number of nodes = 2^h-1
        }else{
            int leftNodecount = countNodes(root.left);
            int rightNodecount = countNodes(root.right);

            return 1 + leftNodecount + rightNodecount;
        }
    }

    public static int heightOfLeftSubtree(Node root) {
        if (root == null) {
            return 0;
        }

        int height = 0;

        while(root != null) {
            height++;
            root = root.left;
        }

        return height;
    }

    public static int heightOfRightSubtree(Node root) {
        if (root == null) {
            return 0;
        }

        int height = 0;

        while(root != null) {
            height++;
            root = root.right;
        }

        return height;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(40);
        root.left.right = new Node(41);
        root.right.left = new Node(32);

        System.out.println(countNodes(root));

    }
}
