package Trees;

/**
 * Approach
 * 1. Check if the node is null
 *    -> if yes, return -1
 *
 * 2. Recursively calculate the height of the left subtree
 *
 * 3. Recursively calculate the height of the right subtree
 *
 * 4. Return 1 + max(leftHeight, rightHeight)
 *
 * TC - O(N)
 * SC - O(H)
 */

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class HeightOfBinaryTree {

    static int height(Node root) {
        if (root == null) {
            return 1;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);


        return 1 + Math.max(leftHeight, rightHeight);
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(50);
        root.left.right = new Node(100);


        System.out.println(height(root));
    }
}
