class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

/*
 * TC = O(N)
 * SC = O(H), where H is the height of the tree
 */

public class PathSum {

    static boolean hasPathSum(Node root, int targetSum) {

        // If node is null, no valid path exists
        if (root == null) {
            return false;
        }

        // Subtract current node value from target sum
        int remaining = targetSum - root.data;

        // Check if current node is a leaf
        if (root.left == null && root.right == null) {
            return remaining == 0;
        }

        // Check for a valid path in left or right subtree
        return hasPathSum(root.left, remaining) || hasPathSum(root.right, remaining);
    }

    public static void main(String[] args) {

        Node root = new Node(5);

        root.left = new Node(4);
        root.right = new Node(8);

        root.left.left = new Node(11);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(2);

        root.right.left = new Node(13);
        root.right.right = new Node(4);
        root.right.right.right = new Node(1);

        System.out.println(hasPathSum(root, 22));
    }
}