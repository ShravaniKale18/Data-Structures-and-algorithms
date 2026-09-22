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

/**
 * Approach
 *
 * For every node:
 * 1. Calculate left subtree height
 * 2. Calculate right subtree height
 * 3. Calculate diameter passing through current node
 * 4. Recursively calculate diameter of left subtree
 * 5. Recursively calculate diameter of right subtree
 * 6. Return the maximum of all three
 *
 * TC - O(N^2) worst case
 * SC - O(H), O(N) worst case
 */

public class DiameterOfBinaryTree {

    static int diameter(Node root) {
        if (root == null) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        int currentDiameter = lh + rh;

        int leftDiamter = diameter(root.left);
        int rightDiamter = diameter(root.right);

        return Math.max(currentDiameter, Math.max(leftDiamter, rightDiamter));
    }


    static int height(Node root) {
        if (root == null) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        return 1 + Math.max(lh, rh);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(50);
        root.left.right = new Node(100);

    }
}
